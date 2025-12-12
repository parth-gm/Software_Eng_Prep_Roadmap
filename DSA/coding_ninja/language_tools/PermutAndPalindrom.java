package language_tools;

import java.util.*;
import java.util.Scanner;

public class PermutAndPalindrom {

	static int[] getPalindrom(String inpStr){
		List<Integer> ansLst = new ArrayList<>();
		HashMap<Character, List<Integer>> hmp = new HashMap<>();
		for(int i=0;i<inpStr.length();i++) {
			if(!hmp.containsKey(inpStr.charAt(i)))
			{
				hmp.put(inpStr.charAt(i), new ArrayList<Integer>());
		
			}
			hmp.get(inpStr.charAt(i)).add(i);
		}
		int isPal = 0;
		for(char key:hmp.keySet()) {
			if(hmp.get(key).size()%2!=0) {
				isPal++;
			}
		}
		
		if(isPal>1) {
			int[] arr = {-1};
			return arr;
		}
		
		int[] arr = new int[inpStr.length()];
		int lptr = 0, rptr = inpStr.length()-1;
		
		for(char key:hmp.keySet()) {
			List<Integer> vec = hmp.get(key);
			if(vec.size()%2==0) {
				
				for(int i=0;i<vec.size();i+=2) {

					arr[lptr] = vec.get(i)+1;
					arr[rptr] = vec.get(i+1)+1;
					lptr++;
					rptr--;
					
				}
				
			}else {
				
				for(int i=0;i<vec.size()-1;i+=2) {

					arr[lptr] = vec.get(i)+1;
					arr[rptr] = vec.get(i+1)+1;
					
					lptr++;
					rptr--;
					
				}
				arr[lptr] = vec.get(vec.size()-1)+1;
				
			}
			
		}

		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int noTest = sc.nextInt();
		for(int i=0;i<noTest;i++) {
			
			String inpStr = sc.next();
			System.out.println(Arrays.toString(getPalindrom(inpStr)));
			
		}
		
	}

}
