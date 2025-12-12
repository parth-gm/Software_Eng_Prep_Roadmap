package ownmath;

public class MathUtils {
	int a;
	
	int b;
	
	MathUtils(){
	}
	MathUtils(int a, int b){
		this.a = a;
		this.b = b;
	}
	public int add(int a, int b) {
		return a+b;
	}
	
	public double divide(int a, int b) {
		return a/b;
	}
	
	public double computeCircleArea(int radius) {
		return (double)3.14*radius*radius;
	}
	
}
