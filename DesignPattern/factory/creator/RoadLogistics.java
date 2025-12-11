package factory.creator;

import factory.product.Transport;
import factory.product.Truck;

public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
