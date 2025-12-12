package dp;

public class MinCost {

	static int min_cost(int[][] input, int si, int sj, int ei, int ej) {
		
		if(si == ei && sj == ej) {
			return input[si][sj];
		}
		
		if(si>ei || sj>ej)
			return Integer.MAX_VALUE;
		
		
		int right = min_cost(input, si, sj+1, ei, ej);
		int bottom= min_cost(input, si+1, sj, ei, ej);
		int diag = min_cost(input, si+1, sj+1, ei, ej);
		
		return input[si][sj]+Math.min(right, Math.min(bottom, diag)); 
		
		
	}
	
	
	static int min_cost_itr(int[][] input, int m, int n ) {
		
		int[][] output = new int[m][n];
		
		output[m-1][n-1] = input[m-1][n-1];
		
		for(int i=m-2;i>=0;i--) 
		{
			output[i][n-1] = output[i+1][n-1]+input[i][n-1];
		}
		
		for(int i=m-2;i>=0;i--)
		{
			output[m-1][i] = output[m-1][i+1]+input[m-1][i];
		}
		
		
		for(int i=m-2;i>=0;i--)
		{
			for(int j=n-2;j>=0;j++) 
			{
				
				output[i][j] = input[i][j] + Math.min(output[i+1][j], Math.min(output[i][j+1], output[i+1][j+1]));
				
			}
			
		}
		
		return output[0][0];
		
	}
	
	public static void main(String[] args) {
	
	}

}
