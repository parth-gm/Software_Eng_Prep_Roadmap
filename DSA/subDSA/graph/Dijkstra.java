package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {

	static HashMap<Integer, Integer> shortestPath(Graph graph, int sourceNodeId, int V){
	
		HashMap<Integer, Integer>  shortestDistFromSourceMap = new HashMap<Integer, Integer>();
		Integer[] nodeIds = graph.getAllNodes();
		
		for(int id:nodeIds) {
			shortestDistFromSourceMap.put(id, Integer.MAX_VALUE);
		}
		
		//Adding sourceNode distance to 0 
		shortestDistFromSourceMap.put(sourceNodeId, 0);
		
		PriorityQueue<Node> pq = new PriorityQueue<>(V);
		
		pq.add(new Node(sourceNodeId, 0));
		
		while(!pq.isEmpty()) {
			Node currentNodeDistPair = pq.remove();
			
			for(Node nbh: graph.getNeighbour(currentNodeDistPair.getV())) {
				int updatedDist = (currentNodeDistPair.getWeight() + nbh.getWeight());
				if(updatedDist<shortestDistFromSourceMap.get(nbh.getV()))
				{
					
					shortestDistFromSourceMap.put(nbh.getV(), updatedDist);
//					System.out.println(shortestDistFromSourceMap);
					pq.add(new Node(nbh.getV(), updatedDist));
				}
			}
			
		}
		
		return shortestDistFromSourceMap;
		
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
	
		int t = sc.nextInt();
		while(t-->0) {
		
			int n = sc.nextInt();
			
			Graph graph = new Graph(n);
			for(int i=0;i<n;i++) {
				graph.addNode(i);
			}
			
			
			int noEdges = sc.nextInt();
			
			for(int i=0;i<noEdges;i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int weight = sc.nextInt();
				graph.addEdge(u, new Node(v, weight));
				graph.addEdge(v, new Node(u, weight));
				
			}
			
			graph.print();
			
//			int sourceNodeId = sc.nextInt();
//			int destNodeId = sc.nextInt();
			HashMap<Integer, Integer> shortestDistFromSourceMap = shortestPath(graph,0, n);
	//		System.out.println(shortestDistFromSourceMap);
			for(int k : shortestDistFromSourceMap.keySet()) {
				System.out.println(k+" "+shortestDistFromSourceMap.get(k));
			}
			
		}
	}

}

/*
 * 
 * 
	'''
	# Sample code to perform I/O:
	
	name = input()                  # Reading input from STDIN
	print('Hi, %s.' % name)         # Writing output to STDOUT
	
	# Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
	'''
	import sys
	# Write your code here
	N = int(input())
	
	dist = dict()
	graph = dict()
	for _ in range(N):
	    mem = int(input())
	    dist[mem] = -1
	    graph[mem] = dict()
	
	E = int(input())
	//edges = list()
	{
	    1: {
	        2: 4,
	        3: 5,
	    }
	}
	
	for _ in range(E):
	    _edge = input()
	    edgs = tuple(int(x) for x in _edge.split(" "))
	    graph[edgs[0]][edgs[1]] = edgs[2]
	
	enter = int(input())
	target = int(input())
	
	def travel(node, distance):
	    for conn_node, value in graph[node].items():
	        if (dist[conn_node] < 0) or (dist[conn_node] > (distance + value)):
	            dist[conn_node] = distance + value
	            travel(conn_node, distance + value)
	
	travel(enter, 0)
	print(dist[target])
 * 
 * 
 * 
 */
