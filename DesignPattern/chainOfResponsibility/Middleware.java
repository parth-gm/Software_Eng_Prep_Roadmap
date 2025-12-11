package chainOfResponsibility;

public abstract class Middleware {
    Middleware nextMiddleware;

    public static Middleware link(Middleware first, Middleware... chain){
        Middleware head = first;
        for(Middleware next: chain){
            head.setNext(next);
            head = next;
        }
        return first;
    }

    public void setNext(Middleware middleware){
        this.nextMiddleware = middleware;
    }

    public boolean checkNext(String email, String password){
        if(this.nextMiddleware==null){
            return true;
        }
        return this.nextMiddleware.check(email, password);
    }

    public abstract boolean check(String email, String password);


}
