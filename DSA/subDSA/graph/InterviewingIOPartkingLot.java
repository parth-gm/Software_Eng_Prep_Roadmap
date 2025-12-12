package graph;

import java.util.Arrays;

public class InterviewingIOPartkingLot {

	public static void main(String[] args) {
		int[][] arr = {
				{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
				{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
				{Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
				{0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE},
				
		};
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==0)
					updateParkingLotDist(arr, i, j, 0);
			}
		}
		
		for(int i=0;i<arr.length;i++)
			System.out.println(Arrays.toString(arr[i]));

	}
	static int[][] directions = {{0, 1},{1, 0}, {-1, 0}, {0, -1}};
	private static void updateParkingLotDist(int[][] arr, int i, int j, int dist) {
		if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==-1 || arr[i][j]<dist)
			return;
		
		
		
		arr[i][j] = Math.min(arr[i][j], dist);
		
		for(int k=0;k<4;k++) {
			int newi = i + directions[k][0];
			int newj = j + directions[k][1];
			
			updateParkingLotDist(arr, newi, newj, dist+1);
		}
		
		
		
		
	}

}
