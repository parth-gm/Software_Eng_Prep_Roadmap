package splitwise;

import java.util.ArrayList;
import java.util.HashMap;

public class Event {
	
	int eventId;
	String eventName;
	ArrayList<User> eventMembers = new ArrayList<>();
	User paidByUser;
	double amount;
	SplitBillStrategy strategy;
	ArrayList<Transection> transections = new ArrayList<>();
	HashMap<User, Double> mapPercent;
	HashMap<User, Double> mapAmount;
	
	public Event(User paidByUser, double amount, String eventName, int eventId) {
		
		
		
	}
	

	public void addUserToEvent(User u) {
		eventMembers.add(u);
	}
	
	//Set Percent Map
	void setPercentMap() {
		
	}
	
	//Set Amount Map
	void setExactMap() {
		
	}
	
	void splitBill(SplitType stype) {
		if(stype== SplitType.EQUAL) {
			transections = strategy.splitByEqual(amount, eventMembers);
		}else if(stype== SplitType.EXACT) {
			transections = strategy.splitByExact(mapAmount, amount, eventMembers);
		}else {
			transections = strategy.splitByPercent(mapPercent, amount, eventMembers);
		}
		
	}
	
	
	

}
