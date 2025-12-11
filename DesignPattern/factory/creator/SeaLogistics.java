package factory.creator;

import factory.product.Ship;
import factory.product.Transport;

public class SeaLogistics extends Logistics{
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
