package adapter;

public class RegularSocket {
    private int holes;

    RegularSocket(int holes){
        this.holes = holes;
    }

    public RegularSocket() {

    }

    public double getHoles() {
        return holes;
    }

    public boolean fits(RegularCharger regularCharger) {
        return regularCharger.getPins()==this.holes;
    }
}
