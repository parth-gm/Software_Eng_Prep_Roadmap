package parking_lot_sys;

public class Ticket {

	int id;
	ParkingSpot parkingSpot;
	String parkingSpotType;
	long issueTimestamp;
	//int parkingFees; //tbd
	
	public Ticket(int id, ParkingSpot parkingSpot, long issueTimestamp){
		this.parkingSpot = parkingSpot;
		this.id = id;
		this.issueTimestamp = issueTimestamp;
		this.parkingSpotType = parkingSpot.parkingType;
	}
	
	
	
}
