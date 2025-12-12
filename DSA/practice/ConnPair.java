package practice;

public class ConnPair {

    int weight;
    int edgeNode;
    public ConnPair(int edgeNode,int weight){
        this.weight=weight;
        this.edgeNode=edgeNode;
    }

    @java.lang.Override
    public String toString() {
        return "ConnPair{" +
                "weight=" + weight +
                ", edgeNode=" + edgeNode +
                '}';
    }
}
