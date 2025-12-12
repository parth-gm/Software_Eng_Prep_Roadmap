package graph;

import java.util.ArrayList;

public class GetPathInMaze {

	static class Point{
		public Point(int r2, int c2) {
			this.r = r2;
			this.c = c2;
		}

		int r, c;
		
		public String toString() {
			return "("+r+","+c+")";
		}
	}
	
	static ArrayList<Point> getPath(boolean[][] maze){
		
		ArrayList<Point> path = new ArrayList<>();
		int r=0, c=0;
		int[][] visited = new int[maze.length][maze[0].length];
		if(traverseMatrix(maze, r, c, path, visited))
			return path;
		return null;
		
	}
	
	private static boolean traverseMatrix(boolean[][] maze, int r, int c, ArrayList<Point> path, int[][] visited) {
		
		if(r>=maze.length || c>=maze[0].length || r<0 || c<0 || !maze[r][c])
			return false;
		
		if(visited[r][c]!=0)
			return visited[r][c]==1?true:false;
		
		System.out.println(r+","+c);
		if(r==maze.length-1  && c==maze[0].length-1) {
			return true;
		}
		int success = 2;
		if(traverseMatrix(maze, r+1, c, path, visited) || traverseMatrix(maze, r, c+1, path, visited))
		{
			path.add(new Point(r, c));
			success = 1;
		}
		visited[r][c] = success;
		return visited[r][c]==1?true:false;
	}

	public static void main(String[] args) {
		
		boolean[][] maze = {{true, true, false},{true, true, false}, {true, true, true}};
		System.out.println(getPath(maze));
		
	}

}
