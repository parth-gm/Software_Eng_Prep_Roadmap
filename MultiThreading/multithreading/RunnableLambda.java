package multithreading;

public class RunnableLambda {
	static void print(String s, int id) {

		for(int i=0;i<5;i++) {
			System.out.println(s+id+ Thread.currentThread().getPriority());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Runnable obj = ()-> print("Hello", 1);
		
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(()->print("Hi", 2));
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		
		System.out.println(t1.getPriority()); //1 => Least Priority
		System.out.println(t2.getPriority()); //10 => Highest Priority
		
		t1.setPriority(Thread.MAX_PRIORITY);
		
		t1.setName("Hello");
		System.out.println(t1.getName());
		
		t1.start();
		t2.start();
		
//		Runnable a = new Runnable() {
//			
//			@Override
//			public void run() {
//				for(int i=0;i<5;i++) {
//					System.out.println("TestA");
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//			}
//		};
		
		t1.join(200);
		
		System.out.println("Done");
		
	}
	
	
}

