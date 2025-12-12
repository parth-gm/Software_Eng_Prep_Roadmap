package lambda;

public class RunnableExample {

	public static void main(String[] args) {
		
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Inside Runnable");
			}
		});

		//This Works because Runnable has a single method
		//If more than 1 method are there then you could not written
		//lambda function of that type.
		Runnable runLambda = () -> System.out.println("Inside");
		
		Thread myLambdaThread =new Thread(runLambda);
		myLambdaThread.run();
	}

}


/*
 * 
 * Java * You could have Interface with method implemented in itself
 *	For interface to be consider as type for Lambada it should have only 1
 *	abstract method with no restriction on default implementation.  
 *	
 *Interface which have only 1 abstract method is called functional interface.
 *So that we can use for lambda expression.
*
*/