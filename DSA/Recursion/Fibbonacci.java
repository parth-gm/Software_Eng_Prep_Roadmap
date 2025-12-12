package Recursion;

public class Fibbonacci {

	static int fib(int n) {
		if(n==1) {
			return 1;
		}
		if(n==0)
			return 0;
		int smallOp1 = fib(n-1);
		int smallOp2 = fib(n-2);
		return smallOp1+smallOp2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(10));
	}

}
