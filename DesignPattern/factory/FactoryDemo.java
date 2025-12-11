package factory;

import factory.creator.Logistics;
import factory.creator.RoadLogistics;
import factory.creator.SeaLogistics;

public class FactoryDemo {
    public static void main(String[] args) {
        String type = "ship";
        Logistics logistics = switch (type) {
            case "truck" -> new RoadLogistics();
            case "ship" -> new SeaLogistics();
            default -> throw new RuntimeException("Not found");
        };
        logistics.planDelivery();
    }
}
