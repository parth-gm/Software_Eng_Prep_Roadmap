package strategy4;

public class Animal {

	private String name;
	private int weight;
	public String favFood;
	
	public void setFavFood(String newFood) 
	{
		favFood = newFood;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getFavFood() {
		return favFood;
	}
	
}
