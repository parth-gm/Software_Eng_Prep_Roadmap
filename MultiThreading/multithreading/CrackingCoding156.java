package multithreading;

class A {
	
	A(){
		
	}
	
	static synchronized void printA() {
		System.out.println("printA");
		
		try {
			Thread.sleep(3000);
			System.out.println("printA Done");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	void printB() {
		System.out.println("printB");
		try {
			Thread.sleep(3000);
			System.out.println("printB Done");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}

public class CrackingCoding156 {

	public static void main(String[] args) {
		A a = new A();
		A ab = new A();
		Thread t1 = new Thread(()->a.printB());
		Thread t3 = new Thread(()->a.printA());
		Thread t2 = new Thread(()->ab.printA());
		
		t1.start();
		t2.start();
		t3.start();
		

	}

}
