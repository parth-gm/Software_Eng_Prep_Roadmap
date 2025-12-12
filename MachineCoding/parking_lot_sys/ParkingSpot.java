package parking_lot_sys;

public abstract class ParkingSpot{
	
	private Vehicle vehicle;
	private int id;
	private  boolean isFilled;
	public String parkingType;

	public ParkingSpot(int id, Vehicle vehicle, String type){
	    this.id = id;
	    this.vehicle = vehicle;
	    this.isFilled = true;
	    this.parkingType = type;
	  }
	  
	  public int get_id(){
	    return this.id;
	  }
	  
	  public boolean is_filled(){
	    return this.isFilled;
	  }
	  
	  public void freeParkingSpot() {
		  this.isFilled = false;
	  }
	  
}
