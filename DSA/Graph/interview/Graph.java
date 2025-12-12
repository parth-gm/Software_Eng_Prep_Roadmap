package interview;

import java.util.*;

public class Graph {

	HashMap<String, List<String>> connection;
	
	public Graph() {
		connection=new HashMap<String,List<String>>();
	}
	
	public void addEdge(String src,String end) {
		
		if(!connection.containsKey(src)) {
			List<String> connectedNodes=new ArrayList<String>();
			connection.put(src,connectedNodes);
		}
		if(!connection.containsKey(end)) {
			List<String> connectedNodes=new ArrayList<String>();
			connection.put(end,connectedNodes);
		}
	
		connection.get(end).add(src);
		connection.get(src).add(end);
		
	}
	
	
	
	
	public List<String> getConnections(String src) {
		return connection.get(src);
		
	}
	
	
}
