package linkedlist;
import java.util.*;

import linkedlist.DoublyLinkedList;
public class LRUCache {
	int capacity ; 
	HashMap<Integer, DoublyLinkedListNode> mapCurrentKeys;
	DoublyLinkedList queue;
	public LRUCache(int capacity) {
	        this.capacity = capacity;
	        this.queue = new DoublyLinkedList();
	        this.mapCurrentKeys = new HashMap<>(this.capacity);
	}
	    
    public int get(int key) {
    DoublyLinkedListNode result = mapCurrentKeys.getOrDefault(key, null);
      if(result!=null) {
    	  queue.remove(result);
    	  queue.addLast(result);
    	  return result.value;
      }
      return -1;
    }
    
    public void put(int key, int value) throws Exception {
    	
    	if(queue.size==this.capacity) {
    		if(mapCurrentKeys.containsKey(key)) {
    			DoublyLinkedListNode current = mapCurrentKeys.get(key);
    			current.value = value;
    			queue.remove(current);
    			queue.addLast(current);
    			
    		}else {
    			DoublyLinkedListNode dn = new DoublyLinkedListNode(key, value);
	    		int keyToRemove = queue.removeFirst().key;
	    		mapCurrentKeys.remove(keyToRemove);
	    		queue.addLast(dn);
	    		mapCurrentKeys.put(key, dn);
    		}
    	}else {
            if(mapCurrentKeys.containsKey(key)) {
            	DoublyLinkedListNode current = mapCurrentKeys.get(key);
            	
    			current.value = value;
    			queue.remove(current);
    			queue.addLast(current);
    		}else {
    			DoublyLinkedListNode dn = new DoublyLinkedListNode(key, value);
    			queue.addLast(dn);
    			mapCurrentKeys.put(key, dn);
    		}
    		
    		
    	}
    	
    }
    
	    
	public static void main(String[] args) {
		LRUCache obj = new LRUCache(1);
		try {
			System.out.println(obj.get(6));
			System.out.println(obj.get(8));
			
			obj.put(12, 1);
			
			System.out.println(obj.get(2));
			obj.put(15, 11);
			obj.put(5, 2);
			obj.put(1, 15);
			obj.put(4, 2);
			System.out.println(obj.get(5));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
