package Ch04_Trees_Graphs;

public class Node {
	public String name;
	public Node[] childrens;
	public State state;
	public int adjecentCount;
	
	public Node(String name,int adjecentLength) {
		childrens=new Node[adjecentLength];
		this.adjecentCount=0;
		this.name = name;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node[] getChildrens() {
		return childrens;
	}
	public void addAdjacent(Node children) {
		if(this.childrens.length>this.adjecentCount) {
			childrens[this.adjecentCount]=children;
			this.adjecentCount++;
		}
		else
			System.out.println("Limit Excedded: Not able to add new childrens");
	}
}
