package adv_recursion;

import java.util.Arrays;

public class TestCalss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = new String[100];
		
		arr[0] = "a";
		arr[1] = "b";
		arr[2] = "c";
		
		String def = "def";
		
		for(int i=0;i<def.length();i++) {
			
			for(int j=0;j<3;j++) {
				arr[j+(i*3)] = arr[j]+def.charAt(i);
			}
		}
		System.out.println(Arrays.toString(arr));
		int a =1000000;
		long b = ((long)a)*1000000;
		System.out.println(b);
	}

}
