package adhoc_problems;

import java.util.Scanner;

public class LightUpbulbs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int revCost = sc.nextInt();
		int flipCost = sc.nextInt();
		
		String str = sc.next();
		int zeroGroups = 0;
		char prev='1';
		for(int i=0;i<n;i++) {
			if(prev=='1' && str.charAt(i)=='0')
				zeroGroups++;
			prev = str.charAt(i);
		}
		if(zeroGroups==0)
			System.out.println(0);
		else
		{
			long ans = (long)Math.min(revCost, flipCost)*(zeroGroups-1) + flipCost;
			System.out.println(ans);
		}
	}

}
