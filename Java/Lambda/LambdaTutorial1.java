package lambda;

public class LambdaTutorial1 {
	
	public void greet(Greeting greeting) {
		greeting.perform();
	}
	
	public static void main(String[] args) {
		
		LambdaTutorial1 lt1 = new LambdaTutorial1();
		Greeting greeting = new HelloWorldGreeting();
//		lt1.greet(greeting);
		
		
//		MyLambda myLambdaFunc = () -> System.out.println(); 
		Greeting lambdaGreeting = () -> System.out.println("Hello World!");
		//		MyAdd addFunction = (int a, int b) -> a+b;
		
		//In below line we have only created function instead of 
		// creating class HelloWorldGreeting.  
		lambdaGreeting.perform();
		
		
		//By Anonymous Inner Class
		Greeting innerClassGreeting = new Greeting() {

			@Override
			public void perform() {
				System.out.println("Hello World!");
				
			}

//			@Override
////			public void another() {
////				// TODO Auto-generated method stub
////				
////			}
			
		};
		//You can think of lambda as it is creating anonymous 
		//inner class (looks similar) but those two are diffrent.
		innerClassGreeting.perform();
		
		
		//You can pass lambda to your object method greet
		lt1.greet(lambdaGreeting);
		
	}
}

interface MyLambda{
	void foo();
}

interface MyAdd{
	int add(int a, int b);
}

//

/* Using a interface to declare 1 method
 * 
 * greeting = () -> Syso("Hello World!"); 
 *
 * doubleNoFunc = (int a) -> a*2;
 * 
 * addFunc = (int a, int b) -> a+b
 * 
 * safeDivideFunc = (int a, int b) -> {
 * 
 * 	if(b==0)
 * 		return 0;
 * 	return a/b;
 * 
 * }
 * 
 * 	stringLengthCountFunc = (String s) -> s.length();
 * 
 * 
 
It is actually invalid to specify return keyword when you have 1 liner
lambda expression without {}

*/