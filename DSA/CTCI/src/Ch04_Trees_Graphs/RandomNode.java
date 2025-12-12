package Ch04_Trees_Graphs;

public class RandomNode {
    //RandomNode Function Remain To Implement
    public static void main(String[] args) {

        TreeNode root=new TreeNode(4);
        root.insertInOrder(2);
        root.insertInOrder(6);
        root.insertInOrder(1);
        root.insertInOrder(3);
        root.insertInOrder(5);
        root.insertInOrder(8);
        root.insertInOrder(7);

        System.out.println(root.getSize());
        System.out.println(root.find(5).data);
        System.out.println(root.find(6).getSize());
        System.out.println(root.find(8));



    }
}
