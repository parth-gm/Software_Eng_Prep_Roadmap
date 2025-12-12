package code;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {

	
	public static void main(String[] args) {
		
		TestQueue tqueue = new TestQueue(16);
		Producer p1 = new Producer(tqueue);
		Consumer c1 = new Consumer(tqueue);
		
		Thread pt1 = new Thread(p1);
		Thread ct1 = new Thread(c1);
		
		pt1.start();
		ct1.start();
		
		
	}

}

class TestQueue{
	
	Queue<Integer> queue;
	Lock lock;
	int limit;
	Condition notFull = (Condition) new Object();
	Condition empty = (Condition) new Object();
	
	public TestQueue(int maxsize) {
		queue = new LinkedList<>();
		lock = new ReentrantLock();
		
		this.limit = maxsize;
	}
	
	void put(int val) {
		
		try {
			lock.lock();
			
			if(queue.size()>this.limit) {
				
			}
			
			queue.add(val);
			System.out.println("Current State of Queue: "+queue);
			
			
		}finally {
			lock.unlock();
		}
		
	}
	
	int get() throws InterruptedException {
		
		try {
			lock.lock();
			if(queue.isEmpty()) {
				wait();
			}
			return queue.poll();
			
		}finally {
			lock.unlock();
		}
		
	}
}


class Producer implements Runnable{

	TestQueue tqueue;
//	Queue<Integer> q;
	
	public Producer(TestQueue tqueue) {
		this.tqueue = tqueue;
	}
	
	@Override
	public void run() {
		int i =0;
		while(i<10) {
			
			this.tqueue.put(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			i++;
		}
		
	}
	
	
}

class Consumer implements Runnable{
	TestQueue tqueue;
//	Queue<Integer> q;
	
	public Consumer(TestQueue tqueue) {
		this.tqueue = tqueue;
	}
	
	@Override
	public void run() {
		int i =0;
		while(i<10) {
			System.out.println(this.tqueue.get());
			i++;
		}
		
	}
}