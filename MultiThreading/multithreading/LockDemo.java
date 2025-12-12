package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	private Lock lock;
	private int balance = 100;
	
	public LockDemo() {
		lock = new ReentrantLock();
	}
	
	public void withdraw(int value) {
		
		
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "withdraw Started");
			Thread.sleep(1000);
			this.balance = balance - value;		
		}catch(InterruptedException e) {
			
		}finally {
			System.out.println(Thread.currentThread().getName() + "withdraw End");
			lock.unlock();
		}
				
		
	}
	
	public void deposite(int value) {
		
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "deposite Started");
			Thread.sleep(100);
			this.balance = balance  + value;
		}catch(InterruptedException e) {
			
		}finally {
			System.out.println(Thread.currentThread().getName() + "deposite End");
			lock.unlock();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockDemo ld = new LockDemo();
		Thread t1 = new Thread(()->ld.deposite(100), "T1");
		Thread t2 = new Thread(()->ld.withdraw(50), "T2");
		Thread t3 = new Thread(()->ld.deposite(100), "T3");
		Thread t4 = new Thread(()->ld.withdraw(50), "T4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		System.out.println(ld.balance);
	}
	
}
