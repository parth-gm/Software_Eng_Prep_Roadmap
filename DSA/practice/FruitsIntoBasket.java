package practice;

import java.util.ArrayList;
import java.util.HashMap;

public class FruitsIntoBasket {

    public static int totalFruit(int[] tree) {
        
    	
    	int seenCounts=1,firstStart=0,secondStart=-1,seen=tree[0];
    	for(int i=1;i<tree.length;i++){
        
    		if(seen==tree[i]) {
    			
    		}else {
    			seenCounts++;
    			
    		}
    	}
        
        return -1;
    }
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		int[] arr= {3,3,3,1,2,1,1,2,3,3,4};
		System.out.println(totalFruit(arr));
		
	}

}
