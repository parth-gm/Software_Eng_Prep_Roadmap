package elevator;

import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		
		Person parth = new Person("parth");
		ArrayList<Elevator> elvs = new ArrayList<>();
		
		Elevator e1 = new Elevator(1);
		Elevator e2 = new Elevator(2);
		Elevator e3 = new Elevator(3);
		
		elvs.add(e1);
		elvs.add(e2);
		elvs.add(e3);
		
		

	}

}
