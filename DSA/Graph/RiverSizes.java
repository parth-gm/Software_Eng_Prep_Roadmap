package graph_coding_blocks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RiverSizes {

	public static void traverseBFS(int[][] mat,boolean[][] visited,int i,int j,List<Integer> sizes) {
		
		int currentRiverSize=0;
		
		if(mat[i][j]==0) return;
		
		Queue<IndexPair> queue=new LinkedList<IndexPair>();
		
		queue.add(new IndexPair(i, j));
		visited[i][j]=true;
		
		while(!queue.isEmpty()) {
			IndexPair first=queue.remove();
			
			int idx_i=first.i;
			int idx_j=first.j;
			
			currentRiverSize++;
			
			
			List<IndexPair> unvisitedNeighbors = getUnvisitedNeighbhors(idx_i,idx_j,mat,visited);
			for(IndexPair p:unvisitedNeighbors) {
				if((!visited[p.i][p.j]) &&  mat[p.i][p.j]!=0) {
					visited[p.i][p.j]=true;
					queue.add(new IndexPair(p.i, p.j));
				}
			}

		}
		if(currentRiverSize>0)
			sizes.add(currentRiverSize);
		
	}
	
	
	public static List<IndexPair> getUnvisitedNeighbhors(int i , int j,int[][] mat,boolean[][] visited){
		
		List<IndexPair> nbrs=new ArrayList<IndexPair>();
		
		if(i>0 && !visited[i-1][j]) {
			nbrs.add(new IndexPair(i-1, j));
		}
		if(i<mat.length-1 && !visited[i+1][j]) {
			nbrs.add(new IndexPair(i+1, j));
		}
		if(j>0 && !visited[i][j-1]) {
			nbrs.add(new IndexPair(i, j-1));
		}
		if(j<mat[0].length-1 && !visited[i][j+1]) {
			nbrs.add(new IndexPair(i, j+1));
		}
		
		return nbrs;
		
	}
	
	
    public static List<Integer> riverSizes(int[][] matrix) {
	
    	List<Integer> sizes=new ArrayList<Integer>();
    	boolean[][] visited=new boolean[matrix.length][matrix[0].length];
    	
    	for(int i=0;i<matrix.length;i++) {
    		for(int j=0;j<matrix[0].length;j++){
    			if(!visited[i][j]) {
    				traverseBFS(matrix,visited,i,j,sizes);
    			}
    		}
    	}
    	
    	return sizes;
    	
    }

    public static void main(String[] args) {
        int matrix[][]= {
              {1, 0, 1, 1, 0},
              {1, 0, 1, 0, 0},
              {1, 0, 1, 0, 1},
              {1, 1, 1, 1, 1},
              {1, 0, 1, 1, 0},
        };
        
        for(int size:riverSizes(matrix)) {
        	System.out.println(size);
        }

    }

}
