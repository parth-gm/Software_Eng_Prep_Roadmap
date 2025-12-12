package producer_consumer;


public class Consumer extends Thread{
	MyBlockingQueue<Integer> q;
	Consumer(MyBlockingQueue<Integer> q){
		this.q = q;
	}
	
	@Override
	public void run()
	{
		while(true) {
			q.take();
			
		}
	}

}
