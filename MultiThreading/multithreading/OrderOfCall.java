package multithreading;

import java.util.concurrent.Semaphore;

public class OrderOfCall {

	Semaphore s1 = new Semaphore(1);
	Semaphore s2 = new Semaphore(1);
	
	public OrderOfCall() {
		s1.acquireUninterruptibly();
		s2.acquireUninterruptibly();
	}
	
	public void first() {
		
		System.out.println("First");
		s2.release();
	}
	
	public void second() {
		s2.acquireUninterruptibly();
		System.out.println("Second");
		s1.release();
		s2.release();
		
	}
	
	public void third() {
		s1.acquireUninterruptibly();
		System.out.println("Third");
		s1.release();
	}
	
	public static void main(String[] args) {
		OrderOfCall oc = new OrderOfCall();
		Thread t1 = new Thread(()->oc.first());
		Thread t2 = new Thread(()->oc.second());
		Thread t3 = new Thread(()->oc.third());
		
		t1.start();
		t2.start();
		t3.start();
		
	}
	
}
