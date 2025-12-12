package multithreading;

public class SyncronizedMethod {

	public static synchronized void foo(String name) {
		try {
			System.out.println("Thread"+ name +".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread"+ name +".foo(): ending");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		SyncronizedMethod to1 = new SyncronizedMethod();
//		SyncronizedMethod to2 = new SyncronizedMethod();
		
		Testclass to1 = new Testclass();
		Testclass to2 = new Testclass();
		
		
		Thread t1 = new Thread(()->to1.foo("First"));
		Thread t2 = new Thread(()->to2.foo("Second"));
		
		t1.start();
		t2.start();
		

	}

}

class Testclass{
	public synchronized void foo(String name) {
		try {
			System.out.println("Thread"+ name +".foo(): starting");
			Thread.sleep(3000);
			System.out.println("Thread"+ name +".foo(): ending");
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
