package practice;

import java.util.*;

public class Graph {


    int V;
    public ArrayList<ConnPair>[] adjList;

    public Graph(int v) {
        V = v;
        adjList= new ArrayList[V];
        for(int i=0;i<v;i++){
            adjList[i]=new ArrayList<ConnPair>();
        }

    }

    public void addEdge(int u,int v,int wt,boolean bidir){

        adjList[u].add(new ConnPair(v,wt));
        if(bidir){
            adjList[v].add(new ConnPair(u,wt));
        }

    }

    public void addEdge(int u,int v,int wt){
        addEdge(u,v,wt,true);
    }

    public void printAdjList(){
        for(int i=0;i<V;i++){
            System.out.print(i+": ");
            for(ConnPair node:adjList[i]){
                System.out.print(node.toString()+",");
            }
            System.out.println();
        }
    }


    public void bfs(int src,int dest){
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[V];
        int[] dist=new int[V];
        int[] parent=new int[V];
        Arrays.fill(parent,-1);

        queue.add(src);
        visited[src]=true;
        while (!queue.isEmpty())
        {
            int first=queue.remove();
            System.out.print(first+" -> ");
            for(ConnPair nbrs:adjList[first]){
                if(!visited[nbrs.edgeNode]){
                    queue.add(nbrs.edgeNode);
                    visited[nbrs.edgeNode]=true;
                    dist[nbrs.edgeNode]=dist[first]+1;
                    parent[nbrs.edgeNode]=first;
                }
            }
        }
//
//        for(int i=0;i<V;i++){
//            System.out.println("Distance of "+i+"th node: "+dist[i]);
//        }

        System.out.println("Shortest dist to destination: "+dist[dest]);
        System.out.println("Shortest Path");
        int temp=dest;
        while(temp!=-1){
            System.out.print("<-"+temp);
            temp=parent[temp];
        }



    }
}
