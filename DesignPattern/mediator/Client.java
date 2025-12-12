package mediator;

public class Client {

	public static void main(String[] args) {
		
		ChatRoom croom = new ChatRoom();
		Participant p1 = new Participant("p1",croom);
		Participant p2 = new Participant("p2",croom);
		Participant p3 = new Participant("p3",croom);
		
		croom.register(p3);
		croom.register(p1);
		croom.register(p2);
		
		
		p1.sendMsg(p3, "Hi P3");
		p2.sendMsg(null, "Hi P3 this is group msg");
		
		
		
	}

}
