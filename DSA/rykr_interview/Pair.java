package roykar;

public class Pair<T,V> {
	T first;
	V second;
	public Pair(T first, V second) {
		super();
		this.first = first;
		this.second = second;
	}
	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}
	
	
}
