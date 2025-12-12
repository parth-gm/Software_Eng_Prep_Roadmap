package dp;

public class SimpleGame {
	public static void main(String[] args) {
		D d = new D();
		d.test();
	}
}


class A{
	
}
class B{
	protected static String var1 = "Hello ";
}
class C extends B{
	
}

class D extends C{
	static void test(){
		B.var1 = "Hello";
		System.out.println(var1);
	}
}