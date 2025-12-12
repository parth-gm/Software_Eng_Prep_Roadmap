package array;

public class JumpGame3 {

	static boolean checkIsPossible(int[] arr, int start, boolean[] visited) {
		
		if(start<0 || start>=arr.length || visited[start]) {
			return false;
		}
		
		if(arr[start] == 0)
			return true;
		
		visited[start] = true;
		boolean positive = false, negative=false;
		
		positive = checkIsPossible(arr, start + arr[start], visited);
	
		negative = checkIsPossible(arr, start - arr[start], visited);
		visited[start] = false;
		
		return positive || negative;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 0, 2, 1, 2};
//		int[] arr = {4,2,3,0,3,1,2};
		boolean[] visited = new boolean[arr.length]; 
		System.out.println(checkIsPossible(arr, 2, visited));
	}

}
