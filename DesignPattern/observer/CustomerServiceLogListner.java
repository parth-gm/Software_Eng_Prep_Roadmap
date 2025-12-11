package observer;

public class CustomerServiceLogListner implements Subscriber{
    int sysCode;


    public CustomerServiceLogListner(int sysCode) {
        this.sysCode = sysCode;
    }

    @Override
    public void update(String eventType, String text) {
        System.out.println("Logging to service eventType: "+ eventType+" and text: "+ text);
    }
}
