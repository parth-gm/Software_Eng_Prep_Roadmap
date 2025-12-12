package language_tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VoterList {

	static List<Integer> getVoters(int n, int[] arr) {
		
		List<Integer> voters = new ArrayList<>();
		

		Arrays.sort(arr);
		int prev = arr[0];
//		System.out.println(Arrays.toString(arr));
		for(int i=1;i<n;i++) {
			
			if(arr[i]==prev) {
				voters.add(arr[i]);
				prev=Integer.MIN_VALUE;
			}else {
				prev = arr[i];
			}
				
		}
		
		return voters;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int totalEle = a+b+c;
		int[] arr = new int[totalEle];
		
		for(int i=0;i<totalEle;i++) {
			arr[i] = sc.nextInt();
		}
		
		List<Integer> voters = getVoters(totalEle, arr);
		
		System.out.println(voters.size());
		for(int vId:voters) {
			System.out.println(vId);
		}
		
		
	}

}
