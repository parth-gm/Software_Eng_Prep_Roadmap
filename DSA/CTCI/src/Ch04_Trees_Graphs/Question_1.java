package Ch04_Trees_Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Question_1 {

	
	public static boolean searchBFS(Graph g, Node start, Node end) {
		Queue<Node> queue=new LinkedList<Node>();
		
		for(Node n:g.getVertices())
			n.state=State.Unvisited;
		
		start.state=State.Visiting;
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Node r=queue.poll();
			if(r!=null)
			{
				for(Node n: r.childrens) {
					if(n.state==State.Unvisited) {
						if(n==end) return true;
						n.state=State.Visiting;
						queue.add(n);
					}
				}
				r.state=State.Visited;
			}
		}
		return false;
		
	}
	
	
	//Only Using Visited and Unvisited State
	public static boolean searchBFSv2(Graph g, Node start, Node end) {
		Queue<Node> queue=new LinkedList<Node>();
		
		for(Node n:g.getVertices())
			n.state=State.Unvisited;
		
		start.state=State.Visited;
		
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Node r=queue.poll();
			
			for(Node n: r.childrens) {
				if(n.state==State.Unvisited) {
					if(n==end) return true;
					n.state=State.Visited;
					queue.add(n);
				}
			}
			
		}
		return false;
		
	}
	
	
	public static boolean searchDFS(Graph g,Node start,Node end) {
		if(start==null) return false;
		start.state=State.Visited;
		
		for(Node n: start.getChildrens()) {
			if(n==end) { System.out.println("Path Found"); return true;}
			if(n.state==State.Unvisited) {
				searchDFS(g, n, end);
			}
		}
		
		return false;
	
	}
	
	public static Graph createGraph() {
		Graph g=new Graph(6);
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		
		for(int i = 0; i < 6; i++) {
			g.addVertex(temp[i]);
		}
		return g;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g=createGraph();
		for(Node n:g.getVertices()) {
			System.out.println("Name: "+n.name);
			System.out.println("Ajacent Count: "+ n.adjecentCount);
			System.out.println("Adjacent Nodes");
			for(Node nc:n.getChildrens())System.out.print(nc.name+" ");
			System.out.println();
		}
		
		Node start=g.getVertices()[0];
		Node end =g.getVertices()[5];
		
//		System.out.println(searchBFS(g,start,end));
//
//		System.out.println(searchBFSv2(g,start,end));
		
		for(Node n:g.getVertices())
			n.state=State.Unvisited;
		System.out.println(searchDFS(g, start, end));
		
	}

}
