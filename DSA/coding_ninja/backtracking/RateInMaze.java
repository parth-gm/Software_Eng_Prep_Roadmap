package backtracking;

import java.util.Scanner;

public class RateInMaze {
	
	static void  print2dArray(int[][] board, int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(board[i][j]+ " ");
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				board[i][j] = sc.nextInt();
			}
		}
		int[][] testBoard = new int[n][n];
		printAllPossiblePath(n, 0, 0, board, testBoard);
	}

	private static void printAllPossiblePath(int n, int i, int j, int[][] board, int[][] testBoard) {
		
		if(i<0 || j<0 || i>=n || j>=n || testBoard[i][j]==1) {
			return;
		}
		
		if(i==(n-1) && j==(n-1) && board[i][j]==1) {
			testBoard[i][j] = 1; 
			print2dArray( testBoard, n);
			System.out.println();
			testBoard[i][j] = 0;
			return;
		}
		
		if(board[i][j] == 1) {
			
			testBoard[i][j] = 1;
			printAllPossiblePath(n, i-1, j, board, testBoard);
			printAllPossiblePath(n, i+1, j, board, testBoard);
			printAllPossiblePath(n, i, j-1, board, testBoard);
			printAllPossiblePath(n, i, j+1, board, testBoard);
			testBoard[i][j] = 0;
		}
		
		return;
		
		
		
	}
}
