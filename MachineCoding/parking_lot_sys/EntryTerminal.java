package parking_lot_sys;

public class EntryTerminal extends Terminal {

	public EntryTerminal(int id) {
		super(id);
	}
	
	public Ticket getTicket(ParkingSpot parkingSpot) {
		
		return new Ticket(1, parkingSpot, System.currentTimeMillis()); //tbd
	}
	
}
