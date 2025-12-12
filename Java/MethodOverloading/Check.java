package codechef;

public class Check {
	int x=5;
	static void myMethod() {
		System.out.println("One of One");
	}
	
	static int myMethod(int x , int y) {
		return x+y;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt="Hello World";
		System.out.print(10>20);
		String cars[]= {"Volvo","BMW","Ford"};
		for(String i: cars)
		{
            System.out.println(i);
		}
		System.out.println(cars.length);
		Check.myMethod();
		System.out.println(myMethod(2,3));
		
		Check myObj= new Check();
		System.out.println(myObj.x);

	}

}
