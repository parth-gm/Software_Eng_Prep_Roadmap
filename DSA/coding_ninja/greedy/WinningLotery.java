package greedy;

import java.util.Scanner;

public class WinningLotery {


    static String getSmallestNo(int D, int S) {
		
		StringBuffer sb = new StringBuffer();
		int endSum = S-1;
        for(int i=0;i<D-1;i++){
           if(endSum>9){
        		sb.append("9");
            	endSum -= 9;
        	}
        	else 
            {
            	sb.append(endSum);
            	endSum=0;
            }
            
        }	
        if(endSum==0)
            sb.append(1);
        else
            sb.append(endSum+1);
		
		return sb.reverse().toString();
		
	}
    
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		while(tests-->0) {
			int S = sc.nextInt();
			int D = sc.nextInt();
			
			System.out.println(getSmallestNo(D, S));
		}

	}

}
