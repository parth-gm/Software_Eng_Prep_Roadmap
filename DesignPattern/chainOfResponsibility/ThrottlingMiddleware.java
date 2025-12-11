package chainOfResponsibility;

public class ThrottlingMiddleware extends Middleware{
    int requestCount;
    long curTime = 0;
    int rpm; // Requests per minute
    public ThrottlingMiddleware(int rpm){
        this.requestCount = 0;
        this.rpm = rpm;
        this.curTime = System.currentTimeMillis();
    }


    @Override
    public boolean check(String email, String password) {
        if(System.currentTimeMillis()>(curTime+60_000)){
            this.requestCount=0;
            this.curTime = System.currentTimeMillis();
        }
        requestCount++;
        if(requestCount>this.rpm){
            System.out.println("Limit reached");
            return false;
        }
        return checkNext(email, password);
    }
}
