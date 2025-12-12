package dp;

public class Fibbonaci {

	static int fib2(int n, int[] arr) {
		
		if(n==0 || n==1) {
			return n;
		}
		
		if(arr[n]>0)
			return arr[n];
		
		int output = fib2(n-1, arr) + fib2(n-2, arr);
		arr[n] = output;
		return output;
		
	}
	
	static int fibIterator(int n) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		for(int i=2;i<=n;i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
