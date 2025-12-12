package Ch03_Stacks_Queues;

public abstract class Animal {
	
	private int orderInQueue;
	protected String name;
	
	public Animal(String name) {
		this.name=name;
	}

	public abstract String name();

	public int getOrder() {
		return this.orderInQueue;
	}
	
	public void setOrder(int order) {
		this.orderInQueue=order;
	}
	
}
