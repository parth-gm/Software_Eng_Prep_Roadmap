package adapter;

public class RegularCharger {

    private int pins;

    RegularCharger(int pins){
        this.pins = pins;
    }

    public RegularCharger() {

    }

    public int getPins() {
        return pins;
    }
}
