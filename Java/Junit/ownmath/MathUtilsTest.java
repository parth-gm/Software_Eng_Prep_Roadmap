package ownmath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_METHOD) //By Default (Even if you not right that will work)
//@TestInstance(TestInstance.Lifecycle.PER_CLASS) //TestClass only created once Instance
//Still There is no gurrenty that method executes in order


/*
 * 
 * @RepeatedTest(3) => 3 times repeated
 * 
 * 
 */



class MathUtilsTest {

	MathUtils mu;
	
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("This needs to run before all!");
	}
	
	@BeforeEach
	void init() {
		mu = new MathUtils();
	}
	
	
	
	@Test
	@DisplayName("Add Method")
	void testAdd() {
		
		int actual = mu.add(1, 3);
		assertEquals(4, actual, "Add Method");
		assertAll(
				() -> assertEquals(2, mu.add(1, 1)),
				() -> assertEquals(5, mu.add(3, 2)),
				() -> assertEquals(10, mu.add(5, 5))
				
			);
	}
	
	@Test
	void testComputeCircleRadius() {
		
		assertEquals(314, mu.computeCircleArea(10));
	}
	
	@Test
	@Disabled //To Skip testcase while running
	void testDivide() {
		
		assertThrows(ArithmeticException.class, () -> mu.divide(1, 0));
	}

}
