package producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

	private Queue<E> queue;
	private int max = 7;
	private Lock lock = new ReentrantLock();
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	
	
	public MyBlockingQueue() {
		queue = new LinkedList<>();
	}
	
	public  void put(E e) {
		
		//Wait for queue to have atleast 1 empty space
		try {
			lock.lock();
			System.out.println("Put:"+queue.size());
			while(queue.size()>=max) {
				System.out.println("Put Await: "+e + " "+Thread.currentThread().getName());
				notFull.await();
			}
			queue.add(e);
			System.out.println("Put: "+e + " "+Thread.currentThread().getName());
			
			System.out.println(queue);
			Thread.sleep(2000);
			notEmpty.signalAll();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public E take() {
		
		try {
			lock.lock();
			while(queue.size()==0) 
			{
				System.out.println("Consume Await: "+ " "+Thread.currentThread().getName());
				notEmpty.await();
			}
			E item = queue.remove(	);
			System.out.println("Consume: "+item + " " +Thread.currentThread().getName());
			System.out.println(queue);
			Thread.sleep(2000);
			notFull.signalAll();
			return item;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		return null;
		
	}
	
	
	public static void main(String[] args) {
		MyBlockingQueue<Integer> mybq = new MyBlockingQueue<>();
		Producer p1 = new Producer(mybq);
		Producer p2 = new Producer(mybq);
		Producer p3 = new Producer(mybq);
//		Producer p4 = new Producer(mybq);
		Consumer c1 = new Consumer(mybq);
		Consumer c2 = new Consumer(mybq);
		Consumer c3 = new Consumer(mybq);
		p1.start();
		p2.start();
		p3.start();
//		p4.start();
		c1.start();
		c2.start();
		c3.start();
	}
	
}
