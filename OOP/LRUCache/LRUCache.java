package gfg;

import java.util.Arrays;
import java.util.HashMap;

public class LRUCache {
	int capacity;
	int[] arr;
	int lruIndex;
	
	HashMap<Integer,Integer> hm;
	public LRUCache(int capacity) {
		this.capacity=capacity;
		arr=new int[capacity];
		hm=new HashMap<Integer, Integer>();
		lruIndex=0;
	}
    
    public int get(int key) {
        
    	if(hm.containsKey(key)) {

    		int itr=lruIndex-1;
    		while(itr>=0) {
    			if(arr[itr]==key) {
    				break;
    			}
    			itr--;
    		}
    		int exchange=arr[itr];
    		while(itr<(lruIndex-1)) {
    			arr[itr]=arr[itr+1];
    			itr++;
    		}
    		
    		arr[lruIndex-1]=exchange;
    		return hm.get(key);
    	}else {
    		return -1;
    	}
    	
    	
    	
    }
    
    public void put(int key, int value) {
        
    	if(!hm.containsKey(key)) {
    		hm.put(key, value);
    		
    		if(lruIndex==capacity) {
    			int rotate=0;
    			hm.remove(arr[0]);
    			while(rotate<(capacity-1)) {
    				arr[rotate]=arr[rotate+1];
    				rotate++;
    			}
    			arr[capacity-1]=key;
    		}else {
    			arr[lruIndex]=key;
        		lruIndex++;
    		}
    	}else {
    		hm.put(key, value);
    		this.get(key);
    	}
    	
    	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lruc=new LRUCache(3);
		lruc.put(1, 1);
		lruc.put(2, 2);
		lruc.put(3, 3);
		lruc.put(4, 4);
		System.out.println(Arrays.toString(lruc.arr));
		
		System.out.println(""+lruc.get(4));
		System.out.println(Arrays.toString(lruc.arr));
		
		
		System.out.println(lruc.get(3));
		System.out.println(Arrays.toString(lruc.arr));
		
		System.out.println(lruc.get(2));
		System.out.println(Arrays.toString(lruc.arr));
		
		System.out.println(lruc.get(1));
		
		
		lruc.put(5, 5);
		System.out.println();
		System.out.println(""+lruc.get(1)+lruc.get(2));
		System.out.println(lruc.get(5));
	}

}
