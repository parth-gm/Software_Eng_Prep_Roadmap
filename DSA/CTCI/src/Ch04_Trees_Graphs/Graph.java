package Ch04_Trees_Graphs;

public class Graph {
	public Node[] vertices;
	public static int MAX_VERTICES=7;
	public int count;
	
	public Graph(int vertextCount) {
		vertices=new Node[vertextCount];
		count=0;
	}
	
	public void  addVertex(Node x) {
		if(count<vertices.length) {
			vertices[count]=x;
			count++;
		}
		else {
			System.out.println("Graph Full: Vertex Limit Excedded");
		}
	}
	
	public Node[] getVertices() {
		return vertices;
	}
}
