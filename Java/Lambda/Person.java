package lambda;

public class Person {

	int id;
	String fname;
	String lname;
	
	Person(String fs, String ls, int id){
		this.id = id;
		this.fname = fs;
		this.lname = ls;
	}
	
	
	public String toString() {
		return id+","+fname+","+lname;
	}
	
}
