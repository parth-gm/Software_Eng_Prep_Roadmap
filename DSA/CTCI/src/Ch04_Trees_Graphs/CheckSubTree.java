package Ch04_Trees_Graphs;

import java.util.ArrayList;

public class CheckSubTree {

    static boolean isSubTree(TreeNode T,TreeNode S){
        if(S==null)
            return true;
        if(T==null)
            return  false;

        if(checkIdentical(T,S)){
            return true;
        }

        return isSubTree(T.left,S) || isSubTree(T.right,S);
    }


    static boolean checkIdentical(TreeNode root1,TreeNode root2){

        if(root1==null && root2==null) return true;

        if(root1!=null && root2!=null)
        {
            if( root1.data==root2.data && checkIdentical(root1.left,root2.left) && checkIdentical(root1.right,root2.right)){
                return  true;
            }
        }

        return  false;


    }

    static void itrateOverBigSubTree(TreeNode bigRoot,int smallData,ArrayList<TreeNode> snodes){

        if(bigRoot==null) return;

        if(bigRoot.data==smallData){
            snodes.add(bigRoot);
        }

        itrateOverBigSubTree(bigRoot.left,smallData,snodes);
        itrateOverBigSubTree(bigRoot.right,smallData,snodes);
    }


    static void storeInOrder(TreeNode root,StringBuffer sb){
        if(root==null){
            sb.append('$');
            return;
        }
        storeInOrder(root.left,sb);
        sb.append(root.data);
        storeInOrder(root.right,sb);
    }

    static void storePreOrder(TreeNode root,StringBuffer sb){
        if(root==null){
            sb.append('$');
            return;
        }
        sb.append(root.data);
        storePreOrder(root.left,sb);
        storePreOrder(root.right,sb);
    }


    static boolean isSubTreeUtill(TreeNode big,TreeNode small){

        StringBuffer sbbig=new StringBuffer();
        StringBuffer sbsmall=new StringBuffer();

        storeInOrder(big,sbbig);
        storeInOrder(small,sbsmall);
        System.out.println("Inorder both");
        System.out.println(sbbig.toString());
        System.out.println(sbsmall.toString());
        boolean contain = sbbig.toString().contains(sbsmall.toString());
        System.out.println(contain);
        if(!contain){
            return false;
        }
        sbbig.delete(0, sbbig.length());
        sbsmall.delete(0, sbsmall.length());


        storePreOrder(big,sbbig);
        storePreOrder(small,sbsmall);


        System.out.println("Preorder both");
        System.out.println(sbbig.toString());
        System.out.println(sbsmall.toString());


        return sbbig.toString().contains(sbsmall.toString());



    }





    public static void main(String[] args) {
        int[] array = {1,2,3,45,5,6,7};
        int[] array1 = {1,2,3,4,5,6,7};
        TreeNode bigRoot=TreeNode.createMinimalBST(array);
        int[] array3 = {8,9,10};
        TreeNode bigleft=TreeNode.createMinimalBST(array3);
        TreeNode updatedRoot=new TreeNode(bigleft,8,bigRoot);
        TreeNode smallRoot=TreeNode.createMinimalBST(array1);
//        ArrayList<TreeNode> suspectNodes=new ArrayList<TreeNode>();
//        itrateOverBigSubTree(updatedRoot,smallRoot.data,suspectNodes);
//        for(TreeNode tn : suspectNodes) {
//            System.out.println(checkIdentical(smallRoot, tn));
//        }

        System.out.println(isSubTree(updatedRoot,smallRoot));
        System.out.println(isSubTreeUtill(updatedRoot,smallRoot));


    }

}
