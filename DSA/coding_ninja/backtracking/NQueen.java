package backtracking;

import java.util.Scanner;

public class NQueen {
	
	static void  print2dArray(int[][] board, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j]+ " ");
			}
		}
	}
	
	private static void nQueenHelper(int n, int row, int[][] board) {
		
		if(row==n) {
			//find soln
			print2dArray(board, n);
			System.out.println();
			return;
		}
		
		for(int c=0;c<n;c++) {
			if(checkValidPosition(n, row, c, board)) {
				board[row][c] = 1;
				nQueenHelper(n, row+1, board);
				board[row][c] = 0;
			}
			
		}
		
	}
	
	
	private static boolean checkValidPosition(int n, int row, int col, int[][] board) {
		
		//check vertically
		for(int i=0;i<row;i++) {
			if(board[i][col]==1)
				return false;
		}
		
		//check diagonaly left
		for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--) {
			if(board[i][j]==1)
				return false;
		}
		
		//check diagonally right
		for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++) {
			if(board[i][j]==1)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		
		placeNQueen(n,board);
		
	
		
		
	}

	private static void placeNQueen(int n, int[][] board) {
		
		nQueenHelper(n, 0, board);
		
	}

	

}
