package graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	int n;
	HashMap<Integer, ArrayList<Node>> adjListMap;
	
	Graph(int n) {
		this.n = n;
		adjListMap = new HashMap<Integer, ArrayList<Node>>();	
	}
	
	void addNode(int u) {
		adjListMap.put(u, new ArrayList<Node>());
	}
	
	void addEdge(int u, Node v) 
	{	
		if(adjListMap.containsKey(u))
		{
			adjListMap.get(u).add(v);
		}else {
			adjListMap.put(u, new ArrayList<Node>());
			adjListMap.get(u).add(v);
		}
	}
	
	Integer[] getAllNodes() {
		return (Integer[])adjListMap.keySet().toArray(new Integer[this.n]);
	}
	
	ArrayList<Node> getNeighbour(int nodeId){
		return adjListMap.get(nodeId);
	}
	
	void print() {
		for(int key: this.adjListMap.keySet()) {
			System.out.println(key+":"+ adjListMap.get(key));
		}
	}
	
}
