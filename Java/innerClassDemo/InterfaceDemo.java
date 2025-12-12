package innerClassDemo;

interface Abc{
	void show();
}

class A{
	void show() {
		System.out.println("In A");
	}
	void display() {
		System.out.println("In A");
	}
}

//class B extends A{
//	void display() {
//		System.out.println("In B");
//	}
//}
//class Implimentor implements Abc{
//
//	@Override
//	public void show() {
//		// TODO Auto-generated method stub
//		System.out.println("Implimentor Called..");
//	}
//	
//}
public class InterfaceDemo {

	public static void main(String[] args) {
		//Anonymous Interface Use
		Abc obj = new Abc() {

			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("Implimentor Called..");
			}
			
		};
		obj.show();
		
		//Anonymous Class Use => Not able to reuse (If needed for limited use then create Anonymous Class)
		
		A a = new A() {
			void display() {
				System.out.println("In B");
			}
		};
		a.display();
		

	}

}
