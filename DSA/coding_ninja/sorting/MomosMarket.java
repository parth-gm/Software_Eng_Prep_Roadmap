package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MomosMarket {

	public static int index(long arr[], long value)
	{
		int start = 0, end=arr.length-1;
	    while(start<end)
	    {
	        int mid=start + (end-start)/2;
	        
	        if(arr[mid]>=value)
	        	end = mid;
	        else
	        	start = mid+1;
	    }
	    if(arr[start]<value)
	    	start++;
	    return start;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        int noShops = sc.nextInt();
        long[] momosRate = new long[noShops];
        for(int i=0;i<noShops;i++){
            
            momosRate[i] = sc.nextLong();
            
        }
        
        for(int i=1;i<noShops;i++) {
        	momosRate[i] = momosRate[i-1]+momosRate[i]; 
        }
//        System.out.println(Arrays.toString(momosRate));
        int q = sc.nextInt();
        while(q-->0){
            long moneySaved = sc.nextLong();
            if(moneySaved>=momosRate[momosRate.length-1])
            	System.out.println(momosRate.length+" "+(moneySaved - momosRate[momosRate.length-1]));
            else if(moneySaved<momosRate[0])
            	System.out.println(0+" "+ moneySaved);
            else
            {
            	int shopIndex = index(momosRate, moneySaved);
            	if(moneySaved<momosRate[shopIndex]) {
            		System.out.println(shopIndex + " "+ (moneySaved-momosRate[shopIndex-1]));
            	}else {
            		System.out.println(shopIndex+1+" "+0);
            	}
            	
            }
            
        }
        
		

	}

}
