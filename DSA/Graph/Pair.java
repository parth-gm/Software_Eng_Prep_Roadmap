package graph_coding_blocks;

public class Pair {
    int weight;
    String edgeNode;
    public Pair(String edgeNode,int weight){
        this.weight=weight;
        this.edgeNode=edgeNode;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "weight=" + weight +
                ", edgeNode='" + edgeNode + '\'' +
                '}';
    }
}
