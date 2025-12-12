package mediator;
import java.util.*;
public class ChatRoom {

	ArrayList<Participant> participantsList;
	
	public ChatRoom() {
		participantsList = new ArrayList<Participant>();
	}
	
	public void register(Participant user) {
		participantsList.add(user);
	}
	
	public void sendMsg(Participant from, Participant to, String msg) {
		
		if(to==null) {
			for(Participant usr: participantsList) {
				if(usr!=from)
					usr.receiveMsg(from, msg);
			}
		}else {
			to.receiveMsg(from, msg);
		}
		
	}

}
