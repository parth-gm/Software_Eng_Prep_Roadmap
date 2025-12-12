package strategy4;

public class GoodsVehicle extends Vehicle {

	public GoodsVehicle() {
		super(new NormalDriveStrategy());
	}

	
	
}
