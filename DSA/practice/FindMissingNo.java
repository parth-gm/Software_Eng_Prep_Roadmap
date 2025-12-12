package practice;

public class FindMissingNo {

	public static int  findMissingNo(int N,int[] givenArr) {
		
		int missing=0;
		
		for(int i=1;i<=N;i++) {
			missing=missing^i;
		}
		
		for(int x:givenArr) {
			missing=missing^x;
		}
		
		return missing;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,2,4,6,3,7,8};
		System.out.println(findMissingNo(8, arr));
		
	}

}
