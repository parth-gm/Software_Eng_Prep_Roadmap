package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountTriplates {
	
	
	static long countTriplets(List<Long> arr, long r) {

        HashMap<Long,Long> leftmap=new HashMap<Long, Long>();
        
        HashMap<Long,Long> rightmap=new HashMap<Long, Long>();
        
        
        for(long x:arr) {
        	
        	if(!rightmap.containsKey(x)) {
        		rightmap.put(x, (long) 1);
        	}else {
        		rightmap.put(x, rightmap.get(x)+1);
        	}
        	
        }
        
        long count=0;
        for(int i=0;i<arr.size();i++) {
        	
        	rightmap.put(arr.get(i),rightmap.get(arr.get(i))-1);
        	
        	if( leftmap.containsKey(arr.get(i)/r) && rightmap.containsKey(r*arr.get(i)) ) {
        		
        		count=count+(leftmap.get(arr.get(i)/r) * rightmap.get(r*arr.get(i))  );
        		
        	}
        	
        	if(!leftmap.containsKey(arr.get(i))) {
        		leftmap.put(arr.get(i), (long) 1);
        	}else {
        		leftmap.put(arr.get(i), leftmap.get(arr.get(i))+1);
        	}
    
        }

        return count;
        

    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Long> ls=new ArrayList<Long>();
		ls.add((long)1);
		ls.add((long) 3);
		ls.add((long) 3);
		ls.add((long) 9);
		ls.add((long) 9);
		ls.add((long) 9);
		ls.add((long) 27);
		ls.add((long) 81);
		System.out.println(countTriplets(ls, 3));
		
		
	}

}
