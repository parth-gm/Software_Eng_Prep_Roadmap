package mediator;

public class Participant {

	ChatRoom chatroom;
	String name;
	public Participant(String name,ChatRoom croom) 
	{
		this.name = name;
		this.chatroom = croom;
	}
	
	public void sendMsg(Participant to, String msg) 
	{
		this.chatroom.sendMsg(this, to, msg);
	}
	
	public void receiveMsg(Participant from, String msg) 
	{
		System.out.println(this.name+" Recived Msg from:"+from.name+" Msg:"+msg);
	}
	
}
