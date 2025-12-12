package decorator;

public class Test {

	public static void main(String[] args) {
		Car car = new LuxuryCar(new BasicCar());
		car.assemble();
	}
}
