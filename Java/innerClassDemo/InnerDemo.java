package innerClassDemo;

 class Outer{

	int a;
	public void show() {
		
	}
	static class Inner{
		public void display() {
			System.out.println("in innder display");
		}
	}
	
}

public class InnerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Outer out = new Outer();
//		Outer.Inner in = out.new Inner();
		Outer.Inner in = new Outer.Inner();
		in.display();	
	}

}
