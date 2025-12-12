package dp;

public class DonutChallenge {

	static boolean isFirstPlayerWin(int n) {
		
		if(n==1)
			return false;
		
		return isFirstPlayerWin(n-1) || isFirstPlayerWin(n-2);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
