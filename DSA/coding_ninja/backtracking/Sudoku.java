package backtracking;

import java.util.Scanner;

public class Sudoku {
	static final int N=9;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] board = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for (int j = 0; j < N; j++) {
				
				board[i][j] = sc.nextInt();
			}
		}
		solveSudoku(board);
		print2dArray(board);
	}

	
	private static boolean solveSudoku(int[][] board) {
		
		int[] emptyPos = findEmptyPosition(board);
		if(emptyPos[0]==-1 && emptyPos[1]==-1) {
			return true;
		}
		for(int i=1;i<=N;i++) {
			if(checkSudoku(emptyPos, board, i)) {
				
				board[emptyPos[0]][emptyPos[1]] = i;
				if(solveSudoku(board)) {
					return true;
				}
				board[emptyPos[0]][emptyPos[1]] = 0;
			}
		}
		
		return false;
		
		
	}

	static boolean checkSudoku(int[] emptyPos, int[][] board, int no) {
		//check horizontally
		for(int i=0;i<N;i++) {
			if(board[emptyPos[0]][i]==no) {
				return false;
			}
		}
		
		//check Vertically
		for(int i=0;i<N;i++) {
			if(board[i][emptyPos[1]]==no) {
				return false;
			}
		}
		
		int[] pos = getStartEndBox(board, emptyPos);
		
		for(int i=pos[0];i<=pos[2];i++) {
			for(int j=pos[1];j<=pos[3];j++) {
				if(board[i][j]==no)
					return false;
			}
		}
		
		return true;
		
	}


	private static int[] getStartEndBox(int[][] board, int[] emptyPos) {
		// TODO Auto-generated method stub
		int[] pos = {-1,-1,-1,-1};
		int i = emptyPos[0], j = emptyPos[1];
		while(i%3!=0) {
			i--;
		}
		
		while(j%3!=0) {
			j--;
		}
		pos[0] = i; pos[1] = j;
		int k = emptyPos[0], m = emptyPos[1];
		
		while((k+1)%3!=0) {
			k++;
		}
		
		while((m+1)%3!=0) {
			m++;
		}
		
		pos[2] = k; pos[3] = m;
		
		return pos;
	}


	private static int[] findEmptyPosition(int[][] board) {
		int[] arr = {-1, -1};
		for(int i=0;i<N;i++) {
			for (int j = 0; j < N; j++) {
				
				if(board[i][j]==0)
				{
					arr[0] =i;
					arr[1] =j;
					return arr;
				}
			}
			
		}
		return arr;
		
	}


	static void print2dArray(int[][] board) {
		for(int i=0;i<N;i++) {
			for (int j = 0; j < N; j++) {
				
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
}
