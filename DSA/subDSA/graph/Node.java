package graph;

public class Node implements Comparable<Node> {

	private int v;
	private int weight;
	
	Node(int v, int weight){
		this.v = v;
		this.weight = weight;
	}
	
	int getWeight() {
		return weight;
	}
	
	int getV() {
		return v;
	}
	
	
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}

	public String toString() {
		return "NodeId:"+this.v+", Weight:"+this.weight;
	}
}
