package Ch01_Arrays_Strings;

import java.util.ArrayList;

public class ZeroMatrix {

	static void printMatrix(int[][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	
	public static int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomIntInRange(min, max);
			}
		}
		return matrix;
	}

	public static void execute(ArrayList<MakeZeroIndex> array, int[][] mat) {
		
		for(int index=0;index<array.size();index++)
		{
			for(int col=0;col<mat.length;col++)
			{
				mat[array.get(index).row][col]=0;
			}
			
			for(int row=0;row<mat[0].length;row++)
			{
				mat[row][array.get(index).col]=0;
			}
		
		}
		
	}
	
	public static int[][] makeZeroEntries(int[][] mat) {
		ArrayList<MakeZeroIndex> arrMakeZero=new ArrayList<MakeZeroIndex>();
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++) {
				if(mat[i][j]==0)
				{
					arrMakeZero.add(new MakeZeroIndex(i, j));
				}
			}
		}
		execute(arrMakeZero,mat);
		return mat;
		

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat=randomMatrix(7,7, 0,10);
		printMatrix(mat);
		mat=makeZeroEntries(mat);
		System.out.println("hi");
		printMatrix(mat);

	}

}
