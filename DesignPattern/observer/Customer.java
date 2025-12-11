package observer;

public class Customer implements Subscriber{
    String email;

    public Customer(String email){
        this.email = email;
    }

    @Override
    public void update(String eventType, String text) {
        System.out.println("Trigger email to:"+ this.email +"Event occured:"+ eventType+" eventInfo: "+text);
    }
}
