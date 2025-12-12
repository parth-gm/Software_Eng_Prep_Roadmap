package parking_lot_sys;

public interface ParkingSpotAssignmentStrategy {
	
	ParkingSpot gatParkingSpot(Terminal terminal) ;
	boolean releaseParkingSpot(ParkingSpot parkingSpot) ;


}
