package TenDaysCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;



public class SortString {

	static String extractKey(String str,int key ) {
		StringTokenizer st=new StringTokenizer(str," ");
		String s=null;
		while(key>=1) {
			s=st.nextToken();
			key--;
		}
		return s;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String[] strs=new String[100];
		int no=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<no;i++) {
			String str=sc.nextLine();
			strs[i]=str;
			
		}
		int key=sc.nextInt();
		String reversal=sc.next(),ordering=sc.next();
		
		ArrayList<CPair> arrpairs=new ArrayList<CPair>();
		for(int i=0;i<no;i++) {
			arrpairs.add(new CPair(strs[i],extractKey(strs[i], key)));
		}
		
		if(ordering.equals("numeric")) {
			Collections.sort(arrpairs, new Comparator<CPair>() {
			    @Override
			    public int compare(CPair o1, CPair o2) {
			        return Integer.parseInt(o1.s2)-Integer.parseInt(o2.s2);
			    }
			});
		}else {
			Collections.sort(arrpairs, new Comparator<CPair>() {
			    @Override
			    public int compare(CPair o1, CPair o2) {
			        return (o1.s2).compareTo(o2.s2);
			    }
			});
		}
		
		if(reversal.equals("true")) {
	        Collections.reverse(arrpairs); 
		}
		
		for(CPair cp:arrpairs) {
			System.out.println(cp.s1);
		}
		
		
	
	}

}
