package practice;

public class Edge {

	int source;
	int dest;
	int weight;
	
	public Edge(int source, int dest, int weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge [source=" + source + ", dest=" + dest + ", weight=" + weight + "]";
	}
	
	
	
}
