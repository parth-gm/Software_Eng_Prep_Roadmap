package practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Soution {

	static int add(int a,int b) {
		return a+b;
		
	}
	
	public static void main(String[] args) {

		FileReader file = null;
		try {
			file = new FileReader("C:\\abc\\file.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	    BufferedReader fileReader = new BufferedReader(file); 

		try {
			 for (int counter = 0; counter < 3; counter++) {
				 System.out.println(fileReader.readLine());
			 }
			fileReader.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
 
	}

}
