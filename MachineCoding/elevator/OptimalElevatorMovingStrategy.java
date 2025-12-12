package elevator;

import java.util.ArrayList;
import java.util.Collections;

public class OptimalElevatorMovingStrategy implements ElevatorMovingStrategy{
	ArrayList<Elevator> elevators;
	ArrayList<Request> requests;
	
	public OptimalElevatorMovingStrategy() {
		
		this.elevators = new ArrayList<>();
		this.requests = new ArrayList<>();
		
	}
	
	public void addElevator(Elevator e) {
		elevators.add(e);
	}
	
	public void removeElevator(Elevator e) {
		elevators.remove(e);
	}

	public void addRequest(Request r) {
		requests.add(r);
	}
	
	public void removeRequest(Request r) {
		requests.remove(r);
	}
	
	@Override
	public void serveElevatorRequests() {
		
		for(Request req: requests) {
			try {
				accomodateRequest(req);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for(Elevator elev: elevators) {
			this.getOptimizedPath(elev);
			System.out.println(elev.optimizedPath);
			
		}
		
	}
	
	private boolean accomodateRequest(Request req) throws Exception
	{
		int minCost = Integer.MAX_VALUE;
		Elevator minCostElev = null;
		for(Elevator elev: elevators) 
		{
			int cost = Integer.MAX_VALUE;
			if(elev.getElevatorStops().isEmpty()) {
				
				cost =0;
				
			}else if(elev.getElevatorStops().size()==1)
			{
				cost = Math.abs(elev.getElevatorStops().get(0) - req.sourcefloorId);
				
			}
			else if(elev.getElevatorStops().size()>=2 &&
					req.sourcefloorId>=elev.getElevatorStops().get(0) && 
					req.sourcefloorId<=elev.getElevatorStops().get(elev.getElevatorStops().size()-1)
					)
			{
				cost = elev.getElevatorStops().get(elev.getElevatorStops().size()-1) - elev.getElevatorStops().get(0);
				
			}
			else if(elev.getElevatorStops().size()>=2 &&
					req.sourcefloorId<elev.getElevatorStops().get(0)) {
				cost = elev.getElevatorStops().get(elev.getElevatorStops().size()-1) - elev.getElevatorStops().get(0) + (elev.getElevatorStops().get(0)-req.sourcefloorId);
			
			}else if(elev.getElevatorStops().size()>=2 &&
					req.sourcefloorId>elev.getElevatorStops().get(elev.getElevatorStops().size()-1)){
				cost = elev.getElevatorStops().get(elev.getElevatorStops().size()-1) - elev.getElevatorStops().get(0) + (req.sourcefloorId- elev.getElevatorStops().get(elev.getElevatorStops().size()-1));
			
			}else {
				throw new Exception("None of Condition Statisfied");
			}
			if(minCost>cost) {
				minCost = cost;
				minCostElev = elev;
			
			}
		}
		
		if(minCostElev!=null) {
			if(!minCostElev.optimizedPath.contains(req.sourcefloorId))
			{
				
				minCostElev.addStopFloor(req.sourcefloorId);
				return true;
			}
		}
		return false;
	}

	public void getOptimizedPath(Elevator e){
		ArrayList<Integer> path = new ArrayList<Integer>();
		
		if(e.getElevatorStops().size()==0) {
			e.optimizedPath.add(e.currentFloor);
			
		}else if(e.getElevatorStops().get(0)>e.currentFloor) {
			e.optimizedPath.addAll(e.getElevatorStops());
			e.optimizedPath.add(0, e.currentFloor);
		
		}else if(e.getElevatorStops().get(e.getElevatorStops().size()-1)<e.currentFloor) 
		{
			e.optimizedPath.addAll(e.getElevatorStops());
			Collections.reverse(e.optimizedPath);	
			e.optimizedPath.add(0, e.currentFloor);
		}
		else {
			int topCost = e.getElevatorStops().get(e.getElevatorStops().size()-1) - e.currentFloor;
			int bottomCost = e.currentFloor - e.getElevatorStops().get(0);
			
			ArrayList<Integer> bottomList = new ArrayList<Integer>();
			ArrayList<Integer> topList = new ArrayList<Integer>();
			for(int cf: e.getElevatorStops()) {
				if(cf<e.currentFloor)
					bottomList.add(cf);
				else 
					topList.add(cf);
			}
			
			e.optimizedPath.add(e.currentFloor);
			
			if(topCost<=bottomCost) {
				e.optimizedPath.addAll(topList);
				Collections.reverse(bottomList);
				e.optimizedPath.addAll(bottomList);
			}else {
				Collections.reverse(bottomList);
				e.optimizedPath.addAll(bottomList);
				e.optimizedPath.addAll(topList);
			}
				
		}
		
	}

	@Override
	public ArrayList<Integer> getPath(Elevator e) {
		// TODO Auto-generated method stub
		return null;
	}
}
