package language_tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TellThePositions {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> arrl = new ArrayList<>();
		int count = sc.nextInt();
		for(int i=0;i<count;i++) {
			String name = sc.next();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			arrl.add(new Student(i+1, name, (a+b+c)));
			
		}
		
		Collections.sort(arrl, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.marks>o2.marks)
					return -1;
				else if(o1.marks==o2.marks)
					return o1.id>o2.id?1:-1;
				return 1;
			}
			
			
		});
		int pos=1;
		for(Student std: arrl) {
			
			System.out.println(pos +" "+ std.name);
			pos++;
		}
		

	}

}

class Student{
	
	int id;
	String name;
	int marks;
	
	public Student(int id, String name, int marks) {
		
		this.id = id;
		this.name = name;
		this.marks = marks;
	
	}
	
}
