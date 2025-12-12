package numbertheory3;

import java.util.Scanner;

public class TotientFunction {

	static int maxLimit = (int)Math.pow(10, 9);
	static int[] euler_q = new int[maxLimit+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int tests = sc.nextInt();
//		int inp[] = new int[tests];
//		int max = -1;
//		int idx=0;
		intializeArray();
		while(tests-->0) {
			 int ele = sc.nextInt();
			 System.out.println(euler_q[ele]);
//			 inp[idx++] = ele;
//			 max = Math.max(ele, max);
		}
//		int[] euler_q = new int[max+1];
//		intializeArray(euler_q, max+1);
//		int curIdx = 0;
//		while(curIdx<idx) {
//			System.out.println(euler_q[inp[curIdx++]]);
//			
//		}
		
		

	}

	private static long euelerPhi(int n) {
		long[] phi = new long[n+1];
		for(int i=1;i<=n;i++) {
			phi[i]=i;
		}
		for(int i=2;i<=n;i++) {
			if(phi[i]==i) {
				phi[i] = i-1;
				for(int j=i*2;j<=n;j+=i) {
					phi[j] =  (phi[j]*(i-1))/i;
				}
			}
		}
		return phi[n];
	}
	
	private static void intializeArray() {
		for(int i=1;i<euler_q.length;i++) {
			euler_q[i]=i;
		}
		for(int i=2;i<euler_q.length;i++) {
			if(euler_q[i]==i) {
				euler_q[i] = i-1;
				for(int j=i*2;j<euler_q.length;j+=i) {
					euler_q[j] =  (euler_q[j]*(i-1))/i;
				}
			}
		}
		
	}

}
