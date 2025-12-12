package Ch03_Stacks_Queues;

public class AnimalShelter_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnimalQueue animals = new AnimalQueue();
		animals.enqueue(new Cat("C1"));
		animals.enqueue(new Cat("C2"));
		animals.enqueue(new Dog("D1"));
		animals.enqueue(new Dog("D2"));
		animals.enqueue(new Cat("C3"));
		animals.enqueue(new Dog("D3"));
		animals.enqueue(new Dog("D4"));
		animals.enqueue(new Cat("C4"));
		
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		
		animals.enqueue(new Dog("D5"));
		animals.enqueue(new Cat("C5"));
		
		
		System.out.println(animals.dequeueDog().name());
		System.out.println(animals.dequeueDog().name());
		
		System.out.println(animals.dequeueAny().name());
//		while (animals.sizes() != 0) {
//			System.out.println(animals.dequeueAny().name());	
//		}
	}

}
