package Ch04_Trees_Graphs;

public class validBSTNew {

    static boolean bstUtil(TreeNode root,int min,int max) {

        if(root==null)
            return true;

        if (root.data < max && root.data > min && bstUtil(root.left, min, root.data) && bstUtil(root.right, root.data, max)) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isBSTv2(TreeNode root){
        return bstUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }


    /*
    static boolean isLeftSubtreeLesser(TreeNode root,int value){
        if(root==null)
            return true;

        if(value>=root.data && isLeftSubtreeLesser(root.left,value) && isLeftSubtreeLesser(root.right,value)){
            return  true;
        }
        else{
            return false;
        }

    }

    static boolean isRightSubtreeGreater(TreeNode root,int value){
        if(root==null)
            return true;


        if(value<=root.data && isRightSubtreeGreater(root.left,value) && isRightSubtreeGreater(root.right,value)){
            return  true;
        }
        else{
            return false;
        }

    }


    static boolean isBST(TreeNode root){

        if(root==null)
            return true;

        if(isLeftSubtreeLesser(root.left,root.data) && isRightSubtreeGreater(root.right,root.data) && isBST(root.left) && isBST(root.right)){
            return true;
        }else
        {
            return false;
        }

    }

*/

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root=TreeNode.createMinimalBST(array);

//        TreeNode root=new TreeNode(5);
//		root.left=new TreeNode(3);
//		root.left.left=new TreeNode(2);
//		root.left.right=new TreeNode(10);


        System.out.println(isBSTv2(root));



    }

}
