package adhoc_problems;

import java.util.Scanner;

public class RectangularArea {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		int noPoints = sc.nextInt();
		int h[] = new int[100000];
		int endPoint = -1;
		for(int i=0;i<noPoints;i++) {
			int x = sc.nextInt();
			int y =sc.nextInt();
			if(h[x/2]!=0)
				h[x/2] = Math.max(h[x/2], y);
			else
				h[x/2] = y;
			
			endPoint = Math.max(x/2, endPoint);
		}
		int area = 0;
		for(int i=endPoint;i>0;i--) {
			
			area+=(Math.max(h[i], h[i+1]));
		
		}
		System.out.println(area*2);

	}

}
