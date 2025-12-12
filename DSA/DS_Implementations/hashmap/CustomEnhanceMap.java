package hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class CustomEnhanceMap<K, V> {

	public static class KVPair<K, V>
	{
		K key;
		V val;
		
		public KVPair(K key, V val) {
			this.key = key;
			this.val = val;
		}
		
		public String toString() {
			return "["+key+":"+val+"]";	
		}
	}
	int capacity=20;
	int size;
	float loadFactor = 0.75f;
	LinkedList<KVPair<K,V>>[] buckets;
	
	
	public CustomEnhanceMap(int capacity, float loadFactor){
		
		intializeMapList();
		this.capacity = capacity;
		this.loadFactor = loadFactor;
	}


	public CustomEnhanceMap(){
		
		intializeMapList();
		
	}
	
	private void intializeMapList() {
		size =0;
		buckets = new LinkedList[capacity];
		for(int i=0;i<capacity;i++) {
			buckets[i] = new LinkedList<KVPair<K, V>>();
		}
	}
	
	public V put(K key, V val) {
		int hashCode =  getHashCode(key);
		int bucketIndex = compressToBucketsRange(hashCode);
		int keyIdx = getKeyIndexInBucket(key, bucketIndex);
		if(keyIdx==-1) {
			buckets[bucketIndex].add(new KVPair<K, V>(key, val));
			size++;
		}else {
			buckets[bucketIndex].get(keyIdx).val = val;
		}
		
		float currentLoadFactor = (float)size/capacity; 
		if(currentLoadFactor>loadFactor)
			rehash();
		
		return val;
	}
	
	private void rehash() {
		capacity = 2*capacity;
		LinkedList<KVPair<K,V>>[] oldBuckets = buckets;
		intializeMapList();
		
		for(int i=0;i<oldBuckets.length;i++) {
			for(KVPair<K, V> node: oldBuckets[i]) {
				put(node.key, node.val);
			}
		}
		
	}

	public ArrayList<K> keySet(){
		ArrayList<K>  keys = new ArrayList<>();
		for(int i=0;i<buckets.length;i++) 
		{
			for(KVPair<K, V> node: buckets[i]) {
				keys.add(node.key);
			}
		}
		return keys;
	}
	
	public int getKeyIndexInBucket(K key, int bucketIndex) {
		int index=0;
		for(KVPair<K, V> node:buckets[bucketIndex]) {
			if(node.key.equals(key)) {
				return index;
			}
			index++;
		}
		return -1;
	}
	
	public int getHashCode(K key) {
		return key.hashCode();
	}
	
	public int compressToBucketsRange(int hashcode) {
		return hashcode%capacity;
	}
	
	public V get(K key) {
		int hashCode =  getHashCode(key);
		int bucketIndex = compressToBucketsRange(hashCode);
		int keyIdx = getKeyIndexInBucket(key, bucketIndex);
		if(keyIdx==-1) {
			return null;
		}
		return buckets[bucketIndex].get(keyIdx).val;
	}
	
	public boolean containsKey(K key) {
		int hashCode =  getHashCode(key);
		int bucketIndex = compressToBucketsRange(hashCode);
		int keyIdx = getKeyIndexInBucket(key, bucketIndex);
		if(keyIdx==-1) {
			return false;
		}
		return true;
	}
	
	public V remove(K key) throws Exception {
		int hashCode =  getHashCode(key);
		int bucketIndex = compressToBucketsRange(hashCode);
		int keyIdx = getKeyIndexInBucket(key, bucketIndex);
		if(keyIdx==-1) {
			throw new Exception("Key Not Exists!");
		}
		KVPair<K, V> temp = buckets[bucketIndex].remove(keyIdx);
		size--;
		return temp.val;
	}
	public void printMap() {
		System.out.println("--------Start-----------");
		for(int i=0;i<capacity;i++) {
			 System.out.println(i+"-->"+buckets[i]);
		}
		System.out.println("---------End---------");
	}
	public static void main(String[] args) throws Exception {
		CustomEnhanceMap<Integer, String> map = new CustomEnhanceMap<>(5, 0.75f);
		map.put(1,  "one");
		map.put(2,  "two");
		map.put(3,  "three");
		map.put(4,  "twoo");
		
		map.printMap();
		map.remove(2);
		System.out.println(map.keySet());
		System.out.println(map.capacity);
	
	}
}
