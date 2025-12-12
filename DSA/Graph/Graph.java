package graph_coding_blocks;

import java.util.*;

public class Graph {

    int V;
    ArrayList<Integer> adjList[];

    public Graph(int v) {
        V = v;
        adjList= new ArrayList[V];
        for(int i=0;i<v;i++){
            adjList[i]=new ArrayList<>();
        }

    }

    public void addEdge(int u,int v,boolean bidir){

        adjList[u].add(v);
        if(bidir){
            adjList[v].add(u);
        }

    }

    public void addEdge(int u,int v){
        addEdge(u,v,true);
    }

    public void printAdjList(){
        for(int i=0;i<V;i++){
            System.out.print(i+": ");
            for(int node:adjList[i]){
                System.out.print(node+",");
            }
            System.out.println();
        }
    }

    public void connectEdges(int[][] mat,int i,int j){

        if(mat[i][j]==0|| i>mat.length || j>mat[0].length){
            return;
        }

        if(mat[i+1][j]==1)
            addEdge(i,j);


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
            for(int nbrs:adjList[first]){
                if(!visited[nbrs]){
                    queue.add(nbrs);
                    visited[nbrs]=true;
                    dist[nbrs]=dist[first]+1;
                    parent[nbrs]=first;
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
