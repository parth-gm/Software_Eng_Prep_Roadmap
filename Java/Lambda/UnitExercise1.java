package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UnitExercise1 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
                new Person("Charles", "Dickens", 60),
                new Person("Lewis", "Carrol", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 38)
        );
		
		//Old Way
//		Collections.sort(people, new Comparator<T>() {
//			
//		});
		people.forEach(p -> System.out.println(p));
		
		Collections.sort(people, (p1, p2) -> p1.lname.compareTo(p2.lname));
		
		printConditionaly(people, p -> true, p -> System.out.println(p));
		
		printConditionaly(people, p -> p.lname.startsWith("B"), p -> System.out.println(p.lname));
		
		
		
	}
	
	//Using out of box interface that already comes with Java
	static void printConditionaly(List<Person> ls, Predicate<Person> condt, Consumer<Person> consumer) {
		for(Person p: ls) {
			if(condt.test(p))
				consumer.accept(p);
//				System.out.println(p);
		}
	}
	
//	
//	static void printConditionaly(List<Person> ls, Condition condt) {
//		for(Person p: ls) {
//			if(condt.test(p))
//				System.out.println(p);
//		}
//	}
//	
	interface Condition{
		boolean test(Person p);
	}
}
