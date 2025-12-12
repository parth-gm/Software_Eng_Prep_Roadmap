package elevator;

import java.util.ArrayList;

public interface ElevatorMovingStrategy {
	void addElevator(Elevator elevator);
	void removeElevator(Elevator elevator);
	void addRequest(Request r);
	void removeRequest(Request r);
	ArrayList<Integer> getPath(Elevator e);
	void serveElevatorRequests();
	void getOptimizedPath(Elevator e);
	
}
