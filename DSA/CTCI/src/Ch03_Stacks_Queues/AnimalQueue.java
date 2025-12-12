package Ch03_Stacks_Queues;

import java.util.LinkedList;

public class AnimalQueue {
	
	LinkedList<Animal> dogs,cats;
	private int order=0;
	public AnimalQueue() {
		dogs=new LinkedList<Animal>();
		cats=new LinkedList<Animal>();
	}
	
	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if(a instanceof Cat) {
			cats.add(a);
		}else{
			dogs.add(a);
		}
	}
	
	public Animal dequeueDog() {
		return  dogs.remove();
	}
	
	public Animal dequeueCat() {
		return  cats.remove();
	}
	
	public Animal dequeueAny() {

		if(cats.isEmpty()) return dogs.remove();
		
		if(dogs.isEmpty()) return cats.remove();
		
		if(cats.peek().getOrder()>dogs.peek().getOrder()) return dogs.remove();
		
		return cats.remove();
	}
	
	public int sizes() {
		return dogs.size()+cats.size();
	}
}
