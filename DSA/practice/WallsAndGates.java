package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

	
	static ArrayList<Room> findAdjacent(int[][] maze,Room r){
		ArrayList<Room> arr=new ArrayList<Room>();
		
		if(r.irow>0 && maze[r.irow-1][r.icol]!=-1 && maze[r.irow-1][r.icol]!=0)
			arr.add(new Room(r.irow-1, r.icol));
		

		if(r.icol>0 && maze[r.irow][r.icol-1]!=-1 && maze[r.irow][r.icol-1]!=0)
			arr.add(new Room(r.irow, r.icol-1));
		

		if(r.irow<(maze.length-1) && maze[r.irow+1][r.icol]!=-1 && maze[r.irow+1][r.icol]!=0)
			arr.add(new Room(r.irow+1, r.icol));
		

		if(r.icol<(maze[0].length-1) && maze[r.irow][r.icol+1]!=-1 && maze[r.irow][r.icol+1]!=0)
			arr.add(new Room(r.irow, r.icol+1));
		
		return arr;
	}
	
	static void applyBfs(int[][] maze,int i,int j) {
		
		Queue<Room> queue=new LinkedList<>();
		
		queue.add(new Room(i,j));
		
		while(!queue.isEmpty()) {
			
			Room r=queue.remove();
			
			ArrayList<Room> list=findAdjacent(maze,r);
			for(Room adjRoom:list) {
				int dist=maze[r.irow][r.icol]+1;
				if(dist<maze[adjRoom.irow][adjRoom.icol]) {
					maze[adjRoom.irow][adjRoom.icol]=dist;
					queue.add(new Room(adjRoom.irow,adjRoom.icol));
				}
			
			}
			
		}
		
		for(int k=0;k<maze.length;k++) {
			for(int l=0;l<maze[0].length;l++) {
				if(maze[k][l]==Integer.MAX_VALUE)
					System.out.print("inf"+" ");
				else
					System.out.print(maze[k][l]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	static void findDistance(int[][] maze)	{
		
		
		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze[0].length;j++) {
			
				if(maze[i][j]==0) {
					applyBfs(maze,i,j);
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	int maze[][]= {{0,-1,0,Integer.MAX_VALUE},
					{Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
					{Integer.MAX_VALUE,-1,-1,-1},
					{0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}	
				};	
	
	findDistance(maze);
		
	}

}
