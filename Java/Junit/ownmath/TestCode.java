package ownmath;

public class TestCode {

	static void testPassByValue(MathUtils mu) {
		mu.a = 4;
//		System.out.println(mu);
		System.out.println(System.identityHashCode(mu.a));
	}
	public static void main(String[] args) {
		MathUtils mu = new MathUtils(2, 3);
		System.out.println(System.identityHashCode(mu.a));
		testPassByValue(mu);
//		System.out.println(mu.a);
		System.out.println(System.identityHashCode(mu.a));
		
		String s1 = new String("2");
		String s2 = "2";
		
		int a = 3;
		int b=3;
		b=2;
		System.out.println(System.identityHashCode(3));
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		
		System.out.println(System.identityHashCode(s2));
		
	}
}
