package graph_coding_blocks;

import java.util.*;

public class AdjacencyList {

    public HashMap<String , List<Pair>> adjList;
    private  boolean udirected;
    public AdjacencyList(boolean udirected) {
        adjList=new HashMap<String, List<Pair>>();
        this.udirected=udirected;
    }

    public void addEdgeHelper(String x,String y,int wt){
        List<Pair> list=adjList.get(x);
        if(list==null){
            list=new LinkedList<Pair>();
            adjList.put(x,list);
        }
        adjList.get(x).add(new Pair(y,wt));
    }

    public void addEdge(String x,String y,int wt){
        if(!adjList.keySet().contains(x))
        {
            adjList.put(x,null);
        }
        if(!adjList.keySet().contains(y))
        {
            adjList.put(y,null);
        }

        addEdgeHelper(x,y,wt);
        if(!this.udirected){
            addEdgeHelper(y,x,wt);
        }
    }

    void printAdjList(){
        for(String key:adjList.keySet()){
            System.out.print(key+": ");
            if(adjList.get(key)!=null){
                for(Pair nbr:adjList.get(key)){
                    System.out.print("( "+nbr.edgeNode+", "+nbr.weight+" )"+" -> ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        AdjacencyList al=new AdjacencyList(true);

        al.addEdge("A","B",20);
        al.addEdge("B","D",40);
        al.addEdge("A","C",10);
        al.addEdge("C","D",40);
        al.addEdge("A","D",50);
        al.printAdjList();
    }
}
