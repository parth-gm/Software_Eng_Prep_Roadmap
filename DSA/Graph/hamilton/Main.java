package hamilton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
public static void printAllHamiltonianPaths(Graph g,int v,
             boolean[] visited,
             List<Integer> path,
             int N)
{

	if (path.size() == N) {
	
		System.out.println(path);
		return;
	}
	for (int w : g.adjList.get(v))
	{
	
		if (!visited[w])
		{
			visited[w] = true;
			path.add(w);
			System.out.println(w);
			
			printAllHamiltonianPaths(g, w, visited, path, N);
			
			visited[w] = false;
			path.remove(path.size()-1);
		}
	}
}
public static void main(String[] args) {
		
		   List<Edge> edges = Arrays.asList(
	                new Edge(0, 1), new Edge(1, 2), new Edge(2, 4),
	                new Edge(4,3), new Edge(1,3)//, new Edge(3,5),new Edge(2,6),new Edge(5,6),new Edge(4,5)
	        );
	 
	        
	        final int N = 5;
	 
	        Graph g = new Graph(edges, N);
	 
	      
	        int start = 0;
	 
	 
	        List<Integer> path = new ArrayList<>();
	        path.add(start);
	 
	       
	        boolean[] visited = new boolean[N];
	        visited[start] = true;
	        System.out.println("sa");
	        printAllHamiltonianPaths(g, start, visited, path, N);
	}

}
