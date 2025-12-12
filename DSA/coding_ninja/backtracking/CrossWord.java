package backtracking;

import java.util.Scanner;
import java.util.StringTokenizer;

public class CrossWord {
	static final int N=10;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char[][] board = new char[N][N];
		
		for(int i=0;i<N;i++) {
			board[i] = sc.next().toCharArray();
		}
		String words = sc.next();
		StringTokenizer st = new StringTokenizer(words,";");
		int wordsNos = st.countTokens();
		String[] wordsArray = new String[wordsNos];
		int idx=0;
		while(st.hasMoreTokens()) {
			wordsArray[idx++] = st.nextToken();
		}
		solveCrossword(board, wordsArray, 0);
	}

	
	private static boolean solveCrossword(char[][] board, String[] words, int index) {
		
		if(index==words.length) {
			print2dArray(board);
			return true;
		}
		System.out.println("solve("+index+")");
		for(int i=0;i<N;i++) {
			for (int j = 0; j < N; j++) {
				
				if(board[i][j] == '-' || board[i][j] == words[index].charAt(0))
				{
					
					if(isValidVertical(board, words[index], i, j))
					{
						int[] helper = new int[words[index].length()];
						
						setVertical(board, words[index], helper,i, j);
						if(solveCrossword(board, words, index+1))
						{
							return true;
						}
						resetVertical(board, words[index], helper, i, j);
					}
					
					if(isValidHorizontal(board, words[index], i, j))
					{
						int[] helper = new int[words[index].length()];
						
						setHorizontal(board, words[index], helper, i, j);
						if(solveCrossword(board, words, index+1))
						{
							return true;
						}
						resetHorizontal(board, words[index], helper, i, j);
					}
						
				}
			}
			
		}
		return false;
	}

	private static void resetHorizontal(char[][] board, String string, int[] helper, int i, int j) {
		// TODO Auto-generated method stub
		int itrLen = 0;
		while(itrLen<string.length()) {
			
			if(helper[itrLen]==1) {
				board[i][j] = '-';
				
			}
			j++;
			itrLen++;
		}
		
	}


	private static void setHorizontal(char[][] board, String string, int[] helper, int i, int j) {
		
		int itrLen = 0;
		while(itrLen<string.length()) {
			
			if(board[i][j]=='-') {
				board[i][j] = string.charAt(itrLen);
				helper[itrLen] = 1;
			}
			j++;
			itrLen++;
			
		}
		
		
	}


	private static boolean isValidHorizontal(char[][] board, String string, int i, int j) {
		
		int start =j;
		int calLen =0;
		
		
		while(start<N && board[i][start]!='+') {
			if(board[i][start]!='-') {
				if(string.charAt(calLen)!=board[i][start])
					return false;
			}
			calLen++;
			start++;
		}
		
		if(calLen<string.length())
			return false;
		
		return true;
		
	}


	private static void resetVertical(char[][] board, String string, int[] helper, int i, int j) {
		
		int itrLen = 0;
		while(itrLen<string.length()) {
			
			if(helper[itrLen]==1) {
				board[i][j] = '-';
				
			}
			i++;
			itrLen++;
		}
		
	}


	private static void setVertical(char[][] board, String string, int[] helper, int i, int j) {
		int itrLen = 0;
		while(itrLen<string.length()) {
			
			if(board[i][j]=='-') {
				board[i][j] = string.charAt(itrLen);
				helper[itrLen] = 1;
			}
			i++;
			itrLen++;
			
		}
		
	}


	private static boolean isValidVertical(char[][] board, String string, int i, int j) {
		int start =i;
		int calLen =0;
		
		
		while(start<N && board[start][j]!='+') {
			if(board[start][j]!='-') {
				if(string.charAt(calLen)!=board[start][j])
					return false;
			}
			calLen++;
			start++;
		}
		
		if(calLen<string.length())
			return false;
		
		return true;
	}


	static void print2dArray(char[][] board) {
		for(int i=0;i<N;i++) {
			for (int j = 0; j < N; j++) {
				
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
