package hashmap;
import java.util.*;
public class CustomMap<K,V> {
	int capacity=20;
	ArrayList<KeyValPair<K, V>>[] mapList;
	
	public CustomMap() {
		
		mapList = new ArrayList[capacity];
		for(int i=0;i<capacity;i++) {
			mapList[i] = new ArrayList<KeyValPair<K, V>>();
		}
		
	}
	
	public V put(K key, V val) {
		int hashcode = getHashCode(key);
		int indexOfBucket = compressFunc(hashcode);
		for(int i=0;i<mapList[indexOfBucket].size();i++) {
			if(mapList[indexOfBucket].get(i).key == key) {
				mapList[indexOfBucket].remove(i);
			}
		}
		mapList[indexOfBucket].add(new KeyValPair<K, V>(key, val));
		return val;
	}

	public V get(K key) {
		int hashcode = getHashCode(key);
		int indexOfBucket = compressFunc(hashcode);
		for(KeyValPair<K,V> ekp: mapList[indexOfBucket]) {
			if(ekp.key.equals(key))
				return ekp.val;
		}
		throw new RuntimeException("Key Not Found");
	}
	
	private int getHashCode(K key) {
		
		return key.hashCode();
	}
	
	public int compressFunc(int hashcode) {
		return hashcode%capacity;
	}
	
	public void printMap() {
		System.out.println("--------Start-----------");
		for(int i=0;i<capacity;i++) {
			 System.out.println(i+"-->"+mapList[i]);
		}
		System.out.println("---------End---------");
	}
	
	public static void main(String[] args) {
		
		CustomMap<Integer, String> map = new CustomMap<>();
		map.put(2, "two");
		map.put(7, "seven");
		map.put(8, "eight");
		map.printMap();
		System.out.println(map.get(2));
		
	}
}
