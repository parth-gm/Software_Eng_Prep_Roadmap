package multithreading;
class Q{
	int num;
	boolean valueSet = false;
	public synchronized void put(int num) {
		while(valueSet) {
			System.out.println("put"+valueSet);
			try {wait();}catch(Exception e) {}
		}
		this.num = num;
		System.out.println("Put "+this.num);
		valueSet = true;
		notify();
	}

	
	public synchronized void get() {
	
		while(!valueSet) {
			System.out.println("get"+valueSet);
			try {wait();}catch(Exception e) {}
		}
		System.out.println("Get "+num);
		valueSet = false;
		notify();
	}
	
}
class Producer implements Runnable{
	Q q;
	Producer(Q q){
		this.q = q;
		Thread t1 = new Thread(this,"Producer");
		t1.start();
	}
	
	@Override
	public void run() {
		int i=0;
		while(true) {
			q.put(i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	
}
class Consumer implements Runnable{
	Q q;
	Consumer(Q q){
		this.q = q;
		Thread t1 = new Thread(this,"Consumer");
		t1.start();
	}
	
	@Override
	public void run() {
		
		while(true) {
			q.get();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	
}

public class InterThreadCommunication {

	public static void main(String[] args) {
		Q q = new Q();
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		
		
	}

}
