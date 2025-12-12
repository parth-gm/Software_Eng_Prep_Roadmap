package interview;

import java.util.*;

public class Solution {

	 static void findAllPossiblePaths(Graph graph, String src, List<String> visitedList,List<String> path ,int noNodes) {
		 if(path.size()==noNodes) {
			 System.out.println(path);
			 return;
		 }
		 for(String nbr:graph.connection.get(src)) {
			 
			 if(!visitedList.contains(nbr)) {
				 visitedList.add(nbr);
				 path.add(nbr);
				 findAllPossiblePaths(graph, nbr, visitedList, path, noNodes);
				
				 visitedList.remove(nbr);	
				 path.remove(path.size()-1);
				 
			 }
			 
		 }
		 
		 
	}
	
	
	
	public static void main(String[] args) {
		
		//String[] Nodes= {"A","B","C","D","E","F"};
		Scanner sc=new Scanner(System.in);
		
		Graph graph=new Graph();
		
		
		System.out.println("Enter total no of Cities:");
		int noNodes=sc.nextInt();
		
		
		System.out.println("Enter total no of edges:");
		int noedge=sc.nextInt();
		
		System.out.println("Enter All Connected Edges:");
		
		for(int i=0;i<noedge;i++) {
			
			
			String a=sc.next();
			String b=sc.next();
			
			graph.addEdge(a, b);
			
		}
		
		System.out.println("Specify Source City: ");
		String src=sc.next();
		
		 List<String> path = new ArrayList<>();
	     path.add(src);
	 
	     List<String> visitedList=new LinkedList<String>(); 
	     visitedList.add(src);
			
	    
		findAllPossiblePaths(graph,src,visitedList,path,noNodes);
	}
	

}
