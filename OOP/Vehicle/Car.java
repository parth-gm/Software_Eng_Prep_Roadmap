public class Car extends Vehical {

	int modelYear;
	  String modelName;

	  public Car(int year, String name) {
	    this.modelYear = year;
	    this.modelName = name;
	  }

	  public static void main(String[] args) {
	    Car myCar = new Car(1969, "Mustang");
	    myCar.honk();
	    System.out.println(myCar.brand+" "+myCar.modelYear + " " + myCar.modelName);
	  }
	
}
