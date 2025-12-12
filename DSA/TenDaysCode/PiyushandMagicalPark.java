package TenDaysCode;

import java.util.Scanner;

public class PiyushandMagicalPark {

	
	static void checkEscape(int N,int M,int K,int S,char[][] arr2d){

		for(int i=0;i<N;i++) {
			
			for(int j=0;j<M;j++) {
				char val=arr2d[i][j];
				if(j<M-1 && val!='#')
					S--;
				if(val=='.') {
					
					S-=2;
				}else if(val=='*') {
					
					S+=5;
				}else if(val=='#') {
					
					break;
				}
			}
			if(S<K)
			{
				System.out.println("No");
				return;
			}
		}
		
		System.out.println("Yes");
		System.out.println(S);
		return;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		int S=sc.nextInt();
		
		char[][] arr2d=new char[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
			{
				arr2d[i][j]=sc.next().charAt(0);
			}
		}
		
		checkEscape(N, M, K, S, arr2d);
		
	}

}
