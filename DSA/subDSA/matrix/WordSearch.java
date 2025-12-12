package matrix;

import java.util.Arrays;

public class WordSearch {

	public static boolean exist(char[][] board, String word) {
	
		if(word.length()==0)
			return true;
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i=0;i<board.length;i++) {
			Arrays.fill(visited[i], false);
		}
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				
				if(board[i][j]==word.charAt(0) && applyDFS(board, i, j, word, 0, visited))
					return true;
				
			}
		}
		return false;
		
	}
	
	private static boolean applyDFS(char[][] board, int i, int j, String word, int wi, boolean[][] visited) {
		
		
		
		if(wi==word.length())
			return true;
		
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j])
			return false;
		
		if(board[i][j]!=word.charAt(wi))
		{
			return false;
		}
		
		visited[i][j] = true;
		
		int[][] darr = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		
		for(int ci=0;ci<4;ci++) {
			
			boolean check =  applyDFS(board, i+darr[ci][0], j+darr[ci][1], word, wi+1, visited);
			if(check)
				return true;
			
			
		}
		visited[i][j] = false;
		return false;
		
		
	}
	
	private static boolean applyDFS(char[][] board, int i, int j, String word, int wi) {
		
		
		
		if(wi==word.length())
			return true;
		
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]=='0')
			return false;
		
		if(board[i][j]!=word.charAt(wi))
		{
			return false;
		}
		char ch = board[i][j];
		board[i][j] = '0';
		
		int[][] darr = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
		
		for(int ci=0;ci<4;ci++) {
			
			boolean check =  applyDFS(board, i+darr[ci][0], j+darr[ci][1], word, wi+1);
			if(check)
				return true;
			
			
		}
		board[i][j] = ch;
		return false;
		
		
	}

	public static void main(String[] args) {
		
//		char[][] arr2d = {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
		char[][] arr2d = {{'a'}};
		System.out.println(exist(arr2d, "a"));
		
	}

}
