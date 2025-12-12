package splitwise;

import java.util.ArrayList;

public class Group {
	int createdByUserId;
	ArrayList<User> groupMembers = new ArrayList<>();
	ArrayList<Event> events = new ArrayList<>();
	ArrayList<Transection> optimizedTransections;
	static SplitAlgo splitalgo = new SplitAlgo();
	
	void addUser(User user) {
		groupMembers.add(user);
	}
	
	void setMinimizedTransections(ArrayList<Event> events) {
		optimizedTransections = splitalgo.getMinimizedTransections(events);
		
	}
	
	
	
}
