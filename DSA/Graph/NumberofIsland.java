package leetcode;

public class NumberofIsland {

	public static void applyDFS(char[][] grid, boolean[][] visited,int i,int j) {
		
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0' || visited[i][j]==true) return;
		
		visited[i][j]=true;
		
		applyDFS(grid,visited,i-1,j);
		applyDFS(grid,visited,i,j-1);
		applyDFS(grid,visited,i+1,j);
		applyDFS(grid,visited,i,j+1);
		
	}
	
	public static int numIslands(char[][] grid) {
	        
		if(grid.length==0)
			return 0;
		boolean[][] visited=new boolean[grid.length][grid[0].length];
		int count=0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				
				if(grid[i][j]=='1' && visited[i][j]==false) {
					applyDFS(grid,visited,i,j);
					count++;
				}		
			}
		}
		
	return count;
	}

	
	public static void main(String[] args) {
	
//	char[][] grid = {
//				{'1','1','1','1','0'},
//				{'1','1','0','1','0'},
//				{'1','1','0','0','0'},
//				{'0','0','0','0','0'}
//		};
//	
		
		char[][] grid= {};
		
		
		System.out.println(numIslands(grid));

	}

}
