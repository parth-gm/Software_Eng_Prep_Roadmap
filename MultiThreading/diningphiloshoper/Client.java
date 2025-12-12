package diningphiloshoper;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		
		Chopstick c1 = new Chopstick();
		Chopstick c2 = new Chopstick();
		Chopstick c3 = new Chopstick();
		Chopstick c4 = new Chopstick();
		Chopstick c5 = new Chopstick();
		
		Philoshoper p1 = new Philoshoper(c1, c2);
		Philoshoper p2 = new Philoshoper(c2, c3);
		Philoshoper p3 = new Philoshoper(c3, c4);
		Philoshoper p4 = new Philoshoper(c4, c5);
		Philoshoper p5 = new Philoshoper(c5, c1);
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		
		p1.join();
		p2.join();
		p3.join();
		p4.join();
		p5.join();
		
		
		
	}
	
}
