package elevator;

import java.util.ArrayList;

public class Elevator {
	
	
	int elevatorId;
	LiftPanel liftPanel;
	Direction currentDirection;
	int currentFloor;
	int destinationFloor;
	ArrayList<Integer> optimizedPath;
	
	
	ArrayList<Person> persons;
	int capacityInKg;
	int waitingTime;
	
	
	public Elevator(int elevatorId) {
		this.elevatorId = elevatorId;
		liftPanel = new LiftPanel();
		optimizedPath = new ArrayList<>();
	}	
	
	public ArrayList<Integer> getElevatorStops() {
		return this.liftPanel.selectedFloors;
	}
	
	public void addStopFloor(int f) 
	{
		if(liftPanel.selectedFloors.contains(f))
		{
			System.out.println("Request of "+f+" already present.");
			return;
		}

		if(liftPanel.selectedFloors.size()==0 || liftPanel.selectedFloors.get(0)>f) {
			liftPanel.addStopFloor(0,f);
			return;
		}
		if(liftPanel.selectedFloors.get(liftPanel.selectedFloors.size()-1)<f) {
			liftPanel.addStopFloor(liftPanel.selectedFloors.size(), f);
			return;
		}
		for(int i=0;i<liftPanel.selectedFloors.size()-1;i++) 
		{
			if(liftPanel.selectedFloors.get(i)<f && liftPanel.selectedFloors.get(i+1)>f) {
				liftPanel.addStopFloor(i+1, f);
				return;
			}
			
		}
	}

	public ArrayList<Integer> getOptimizedPath() {
		return optimizedPath;
	}

	public void setOptimizedPath(ArrayList<Integer> optimizedPath) {
		this.optimizedPath = optimizedPath;
	}
	
	
	
	
	
	
}
