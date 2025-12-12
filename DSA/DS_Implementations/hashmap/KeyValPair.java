package hashmap;

public class KeyValPair<K,V> {
	K key;
	V val;
	
	public KeyValPair(K key, V val) {
		this.key = key;
		this.val = val;
	}
	
	public String toString() {
		return "["+key+":"+val+"]";
		
	}
}
