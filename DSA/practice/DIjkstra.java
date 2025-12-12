package practice;

public class  DIjkstra {

	static int findMinVertex(int[] distances,boolean[] visited) {
		
		int minvertex=-1;
		for(int i=0;i<distances.length;i++) {
			if(!visited[i] && (minvertex==-1|| distances[minvertex]>distances[i])) {
				minvertex=i;
				
			}
		}
		return minvertex;
		
	}
	
	static void dijkstra(int v,Graph graph) {
		
		int[] distances=new int[v];
		boolean[] visited=new boolean[v];
		for(int i=0;i<v;i++) {
			distances[i]=Integer.MAX_VALUE;
		}
		
		distances[0]=0;
		
		
		for(int i=0;i<v-1;i++) {
			
			int u=findMinVertex(distances,visited);
			visited[u]=true;
			for(ConnPair nigbrs:graph.adjList[u]) {
				
				if(!visited[nigbrs.edgeNode]) {
					int curDist=distances[u]+nigbrs.weight;
					if(distances[nigbrs.edgeNode]>curDist) {
						distances[nigbrs.edgeNode]=curDist;
					}
				}
			}
			
		}
		
		for(int i=0;i<v;i++) {
			System.out.println("for 0 to "+i+" "+distances[i]);
		}
		
	}
	
    public static void main(String[] args) {
    	
    	int v=5;
        Graph graph=new Graph(v);

        graph.addEdge(0,1,4);
        graph.addEdge(0,2,8);
        graph.addEdge(1,2,2);
        graph.addEdge(1,3,5);
        graph.addEdge(2,3,5);
        graph.addEdge(2,4,9);
        graph.addEdge(3,4,4);

        graph.printAdjList();

        dijkstra(v,graph);


    }


}
