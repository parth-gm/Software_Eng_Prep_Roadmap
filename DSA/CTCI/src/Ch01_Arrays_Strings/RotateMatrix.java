package Ch01_Arrays_Strings;

public class RotateMatrix {
	
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

	static int[][] rotateMatrix(int[][] matrix){
		
		if(matrix.length!=matrix[0].length || matrix.length==0) {
			System.out.println("Roration not possible");
			return matrix;
		}
		int[][] rotate90mat=new int[matrix.length][matrix.length];
		
		for(int j=0;j<matrix.length;j++)
		{
			for(int k=0;k<matrix.length;k++)
			{
				rotate90mat[k][matrix.length-1-j]=matrix[j][k];
			}
		}
		return rotate90mat;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix= randomMatrix(3, 3, 25, 30);
		printMatrix(matrix);
		int[][] mat =rotateMatrix(matrix);
		System.out.println();
		printMatrix(mat);
	}

}
