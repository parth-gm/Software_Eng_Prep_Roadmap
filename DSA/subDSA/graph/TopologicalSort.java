package graph;

import java.util.Stack;

public class TopologicalSort {

	
	
	public static void main(String[] args) {
		
	
		Graph graph = new Graph(7);
		for(int i =0 ;i<7;i++) {
			graph.addNode(i);
		}
	
		
		boolean[] visited = new boolean[7];
		Stack<Integer> stack = new Stack<>();
		topologicalSort(graph, 0, visited,  stack);
		
	}
	
	
	public static void topologicalSort(Graph graph, int src, boolean[] visited, Stack<Integer> stack) {
		
		visited[src] = true;
		
		for(Node nb: graph.getNeighbour(src)) {
			if(!visited[nb.getV()]) {
				topologicalSort(graph, nb.getV(), visited, stack);
			}
		}
		stack.add(src);
		
	}
	
}
