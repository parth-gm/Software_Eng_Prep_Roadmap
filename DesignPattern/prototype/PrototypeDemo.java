package prototype;

public class PrototypeDemo {

    static void main() {
        Bike bike = new Bike("yamaha", 11);

        Bike bikeCopy = (Bike) bike.clone();
        System.out.println(bikeCopy.toString());

        System.out.println(bike.equals(bikeCopy));
        System.out.println(bike == (bikeCopy));


    }
}
