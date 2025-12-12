package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
		int n = matrix.length, m=matrix[0].length;
		int tne = n*m;
		int count = 0;
		
		for(int i=0;i<=	n/2;i++) {
			
			for(int top = i;top<=m-i-1 && count<tne;top++) {
				list.add(matrix[i][top]);
				count++;
			}
			
			for(int right=i+1;right<=n-i-1 && count<tne;right++) {
				list.add(matrix[right][m-1-i]);
				count++;
			}
			
			for(int bottom=m-i-2;bottom>=i && count<tne;bottom--) {
				list.add(matrix[n-i-1][bottom]);
				count++;
			}
			
			for(int left=n-2-i;left>i && count<tne;left--) {
				list.add(matrix[left][i]);
				count++;
			}
			
		}
		return list;
		
    }
	public static void main(String[] args) {
//		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//		int[][] matrix = {{1,2,3},{4, 5, 6},{7, 8, 9}};
		int[][] matrix = {{1,2,3}};
		
		for(int ele :spiralOrder(matrix)) {
			System.out.println(ele);
		}
	}

}
