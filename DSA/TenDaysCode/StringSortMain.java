package TenDaysCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringSortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList<ObjectClass> arrl=new ArrayList<ObjectClass>();
		int no=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<no;i++) {
			String str=sc.nextLine();
			arrl.add(new ObjectClass(str));
			
		}
		ObjectClass.key=sc.nextInt();
		boolean reversed=sc.nextBoolean();
		ObjectClass.compareType=sc.next();
		CompareTwo ctwo=new CompareTwo();
		if(!reversed)
				Collections.sort(arrl, ctwo); 
		else
			Collections.sort(arrl, Collections.reverseOrder(ctwo)); 
		
		
		for(int i=0;i<no;i++) {
			System.out.println(arrl.get(i));
		}
		
	}

}
