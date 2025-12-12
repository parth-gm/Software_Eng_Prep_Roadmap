package diningphiloshoper;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
	private Lock lock;
	
	public Chopstick() {
		lock = new ReentrantLock();
	}
	
	public void pickUp() {
//		return lock.tryLock();
		lock.lock();
	}
	
	public void putDown() {
		lock.unlock();
	}
	
}
