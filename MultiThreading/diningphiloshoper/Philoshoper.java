package diningphiloshoper;

public class Philoshoper extends Thread {
	private int bites = 10;
	private Chopstick left, right;
	
	public Philoshoper(Chopstick right, Chopstick left) {
		this.right = right;
		this.left = left;
	}

	@Override
	public void run() {
//		while(!eat()) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		while(bites-->0)
			eat();
		
	}
/*
	private boolean eat() {
		if(pickUp()) {
			chew();
			pickDown();
			return true;
		}
//		pickUp();
//		chew();
//		pickDown();
		return false;
	}
*/
	private void eat() {
		pickUp();
		chew();
		pickDown();
	
	}
	
	private void chew() {
		System.out.println("Eating"+Thread.currentThread().getName());
		
	}

	private void pickDown() {
		right.putDown();
		left.putDown();
	
	}

	private void pickUp() {
		left.pickUp();
		right.pickUp();
//		if(!left.pickUp())
//			return false;
//		
//		if(!right.pickUp()) {
//			left.putDown();
//			return false;
//		}
//		return true;
	}

}
