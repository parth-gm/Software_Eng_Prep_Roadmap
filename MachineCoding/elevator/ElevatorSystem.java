package elevator;

import java.util.ArrayList;

public class ElevatorSystem {

	ElevatorMovingStrategy strategy;
	
	public ElevatorSystem(ElevatorMovingStrategy strategy) 
	{
		this.strategy = strategy;
	}
	
	
	public void addElevator(Elevator e) {
		strategy.addElevator(e);
	}
	
	public void removeElevator(Elevator e) {
		strategy.removeElevator(e);
	}
	
	public void addRequest(Request r) {
		strategy.addRequest(r);
	}
	
	public void removeRequest(Request r) {
		strategy.removeRequest(r);
	}
	
	public void serveElevatorRequests() {
		strategy.serveElevatorRequests();
	}
	
	
}
