package lambda;

public class TypeInferenceExample {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//StringLengthLambda myLambda = (String s) -> s.length();
		StringLengthLambda myLambda = s -> s.length();
//		System.out.println(myLambda.getLength("Hello World!"));
//	
		printLambda(s -> s.length());
	}
	
	
	public static void printLambda(StringLengthLambda sl) {
		System.out.println(sl.getLength("Hello World!"));
	}
	
	interface StringLengthLambda{
		int getLength(String s);
	}

}
