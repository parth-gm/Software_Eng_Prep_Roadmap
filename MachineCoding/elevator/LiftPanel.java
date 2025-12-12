package elevator;

import java.util.ArrayList;

public class LiftPanel{
	
	ArrayList<Integer> activeFloors;
	ArrayList<Integer> selectedFloors;
	
	public LiftPanel() {
		activeFloors = new ArrayList<>();
		selectedFloors = new ArrayList<>();
	}
	
	ArrayList<Integer> getselectedFloors() throws Exception{
		for(int f:selectedFloors) {
			if(!activeFloors.contains(f))
				throw new Exception("Inactive floor");
		}
		return selectedFloors;
	}
	
	void addStopFloor(int index, int f)
	{
		selectedFloors.add(index, f);
	}
	
	
	
	
}
