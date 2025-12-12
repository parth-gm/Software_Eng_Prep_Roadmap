package bit_mask;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class SetIthBit {

	  static class FastReader {
	        BufferedReader br;
	        StringTokenizer st;
	 
	        public FastReader()
	        {
	            br = new BufferedReader(
	                new InputStreamReader(System.in));
	        }
	 
	        String next()
	        {
	            while (st == null || !st.hasMoreElements()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                }
	                catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            return st.nextToken();
	        }
	 
	        int nextInt() { return Integer.parseInt(next()); }
	 
	        long nextLong() { return Long.parseLong(next()); }
	 
	        double nextDouble()
	        {
	            return Double.parseDouble(next());
	        }
	 
	        String nextLine()
	        {
	            String str = "";
	            try {
	                str = br.readLine();
	            }
	            catch (IOException e) {
	                e.printStackTrace();
	            }
	            return str;
	        }
	    }
	 
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		while(tests-->0) {
			
			int n = sc.nextInt();
			int i = sc.nextInt();
//			System.out.println(n&(~(1<<i)));
//			int counter=0;
//			while(counter<32) {
//				
//				if((n&(1<<counter))!=0) {
//					
//					//System.out.println((n&(1<<counter)));
//					System.out.println((n&(~(1<<counter))));
//					
//					break;
//				}
//				counter++;
//				
//			}
//				
			
			int ans = n&((1 << i) -1);
			System.out.println(ans);
			
			
		}
		
	}

}
