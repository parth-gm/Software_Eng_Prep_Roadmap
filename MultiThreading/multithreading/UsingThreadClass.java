package multithreading;

public class UsingThreadClass {

	
	public static void main(String[] args) {
		
		Runnable a = new TestA();
		Thread b = new TestB();
		
//		Thread t1 = new Thread(()-> print());
		
		Thread t1 = new Thread(a);
//		Thread t2 = new Thread(b);
		
		
		t1.start();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.start();
		
	}

}

class TestA implements Runnable{
	@Override
	public void run() {
		
		
		for(int i=0;i<5;i++) {
			System.out.println("TestA");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class TestB extends Thread{
	
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("TestB");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}