package practice;

import java.util.Arrays;

public class MinPlatforms {

	static int findMinPlatforms(int[] arrivals,int[] departures) {
		
		int maxplatforms=1,neededplatforms=1;
		
		Arrays.sort(arrivals);
		Arrays.sort(departures);
		
		int arri=1,depi=0;
		
		
		while(arri<arrivals.length-1 && depi<departures.length-1) {
			
			if(arrivals[arri]<departures[depi]) {
				maxplatforms++;
				if(neededplatforms<maxplatforms)
				{
					neededplatforms=maxplatforms;
				}
				arri++;
			}else {
				maxplatforms--;
				depi++;
			}
			
		}
		return neededplatforms;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrivals= {900,940,950,1100,1500,1800};
		int[] departures= {910,1200,1120,1130,1900,2000};
		
		System.out.println(findMinPlatforms(arrivals,departures));
		

	}

}
