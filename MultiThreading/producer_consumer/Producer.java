package producer_consumer;

public class Producer extends Thread {
	MyBlockingQueue<Integer> q;
	Producer(MyBlockingQueue<Integer> q){
		this.q = q;
	}
	
	@Override
	public void run()
	{
		Integer i=0;
		while(true) {
			q.put(i);
			i++;
		
		}
	}
	
	
	
}
