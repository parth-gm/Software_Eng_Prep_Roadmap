package adapter;

public class SocketAdapter extends RegularCharger{
    private IOSCharger iosCharger;

    public SocketAdapter(IOSCharger iosCharger) {
        super();
        this.iosCharger = iosCharger;
    }

    @Override
    public int getPins() {
        return  iosCharger.getPins()+1;
    }
}

