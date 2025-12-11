package observer;

public class MainDemo {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();
        eventManager.subscribe("addedChips", new Customer("parth@gmail.com"));
        eventManager.subscribe("addedChips", new Customer("rahul@gmail.com"));

        eventManager.notify("addedChips", "Balaji Chips added");

        eventManager.subscribe("backendLogUpdate", new CustomerServiceLogListner(123));
        eventManager.subscribe("backendLogUpdate", new CustomerServiceLogListner(345));

        eventManager.notify("backendLogUpdate", "Logs updated to backend sys");


    }
}
