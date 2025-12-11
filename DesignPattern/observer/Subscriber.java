package observer;

public interface Subscriber {
    void update(String eventType, String text);
}
