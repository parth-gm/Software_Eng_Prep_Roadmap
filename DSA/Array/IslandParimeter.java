package leetcode_july;

public class IslandParimeter {

	static int findParameter(int[][] input) {
		int count=0;
		for(int i=0;i<input.length;i++) {
			
			for(int j=0;j<input[0].length;j++) {
				
				if(input[i][j]==1) {
					
					if(i==0) count++;
					if(i==input.length-1) count++;
					
					if(j==0) count++;
					if(j==input[0].length-1) count++;
					
					if(i>0 && input[i-1][j]==0) {
						count++;
					}
					
					if(j>0 && input[i][j-1]==0)
						count++;
					
					if(i<input.length-1 && input[i+1][j]==0)
						count++;
					
					if(j<input[0].length-1 && input[i][j+1]==0)
						count++;
					
				}
			}
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input= {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		
		System.out.println(findParameter(input));
	}

}
