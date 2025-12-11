package observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<Subscriber>> map ;

    public EventManager() {
        this.map = new HashMap<>();
    }

    public void subscribe(String eventType, Subscriber subscriber){
        if(!map.containsKey(eventType)) {
            map.put(eventType, new ArrayList<>());
        }

        List<Subscriber> subscriberList = map.get(eventType);
        subscriberList.add(subscriber);
    }

    public void unsubscribe(String eventType, Subscriber subscriber){
        List<Subscriber> subscriberList = map.get(eventType);
        subscriberList.remove(subscriber);
    }

    public void notify(String eventType, String text){
        for(Subscriber subscriber: map.get(eventType)){
            subscriber.update(eventType, text);
        }
    }


}
