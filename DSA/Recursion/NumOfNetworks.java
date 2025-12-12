package code;
import java.util.*;


public class NumOfNetworks {
	
	static int  countOfNetworks;

	static void getPossibleNetworks(int[] speed, int numComputers, int speedThreshold, 
                  				int curP, ArrayList<Integer> curl){

		if(curl.size()==numComputers){
			int sum = 0;
			for(int ele: curl){
				sum+=ele;
			}
			if(sum>speedThreshold)
				countOfNetworks++;
			return;
		}


		for(int i=curP;i<speed.length;i++){

			curl.add(speed[i]);
			getPossibleNetworks(speed, numComputers, speedThreshold, i, curl);
			curl.remove(curl.size()-1);

		}

	}
	
	public static void main(String[] args) {
		int n = 6;

		int[] speed = {5, 7, 9, 12, 10, 13};
		int minComps = 2 ;

		ArrayList<Integer> curl = new ArrayList<Integer>();
		
		getPossibleNetworks(speed, 2, 15, 0, curl);
		
		System.out.println(countOfNetworks);
		
		
	}
	

}
