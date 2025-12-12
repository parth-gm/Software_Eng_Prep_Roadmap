package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class MaximumDepthClient {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] edges = new int[N-1][2];
            for(int i_edges = 0; i_edges < N-1; i_edges++)
            {
            	String[] arr_edges = br.readLine().split(" ");
            	for(int j_edges = 0; j_edges < arr_edges.length; j_edges++)
            	{
            		
            		edges[i_edges][j_edges] = Integer.parseInt(arr_edges[j_edges]);
            	}
            }
            String[] arr_w = br.readLine().split(" ");
            int[] w = new int[N];
            for(int i_w = 0; i_w < arr_w.length; i_w++)
            {
            	w[i_w] = Integer.parseInt(arr_w[i_w]);
            }

            int[] out_ = max_depth(N, edges, w);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
            	System.out.print(" " + out_[i_out_]);
            }
            
            System.out.println();
            
         }

         wr.close();
         br.close();

	}
	
	static int[] max_depth(int N, int[][] edges, int[] w){
		//Initialize Graph
		Graph graph = new Graph(N);
		for(int i=0;i<N-1;i++) {
			graph.addEdge(edges[i][0]-1, edges[i][1]-1);
		}
		
		List<Integer> queue = new LinkedList();
		
		int nodesToRemove = 0;
		
		// Nodes in Adjecency list where single neighbour present are leaf node except root node that is at 0th Index
		for(int i=1;i<N;i++) {
			if(graph.adjList[i].size()==1 && w[i]%2==0) {
				queue.add(i);
				nodesToRemove++; //as per constraint in question
			}
		}
		
		//Using Queue Data structure to update adjecency list in recursive manner and increment nodes to remove based on given constraint
		while(!queue.isEmpty()) {
			int node = queue.remove(0);
			int connectedNode = graph.getNeighbour(node).get(0);
			
			graph.removeEdge(connectedNode, node); //Updating Adjecency List
			
			if(connectedNode!=0 && graph.adjList[connectedNode].size()==1 && w[connectedNode]%2==0) // Root node is not leaf (connectedNode!=0)
			{
				queue.add(connectedNode);
				nodesToRemove++;
			}
		}
		
		//Calculate remaining nodes and max depth
		int[] ans = new int[2];
		ans[0] = N- nodesToRemove;
		ans[1] = graph.getMaxDepth(0);
		return ans;
	}

}
