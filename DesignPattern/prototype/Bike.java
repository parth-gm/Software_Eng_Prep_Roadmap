package prototype;

import java.util.Objects;

public class Bike implements Prototype {

    private int numberPlate;
    private String name;

    public Bike(Bike bike) {
        this.numberPlate = bike.numberPlate;
        this.name = bike.name;
    }

    public Bike(String name, int numberPlate) {
        this.name = name;
        this.numberPlate = numberPlate;
    }

    @Override
    public Prototype clone() {
        return new Bike(this);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "numberPlate=" + numberPlate +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode(){
        return Objects.hash(numberPlate, name);
    }
    // If two objects are equal there hashcode should be equal

    @Override
    public boolean equals(Object object2) {
        if (this == object2) return true;
        if (!(object2 instanceof Bike)) return false;
        Bike bike2 = (Bike) object2;
        return bike2.numberPlate == this.numberPlate && (bike2.name.equals(this.name));
    }
}
