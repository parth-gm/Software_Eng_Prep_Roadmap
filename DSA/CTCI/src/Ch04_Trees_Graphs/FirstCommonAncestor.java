package Ch04_Trees_Graphs;

import java.util.ArrayList;
import java.util.Iterator;

public class FirstCommonAncestor {

    static  TreeNode lca(TreeNode root, int p,int q){
        if(root==null) return null;
        if(root.data==p || root.data==q){
            return  root;
        }
        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);

        if(left!=null && right!=null)return root;
        if(left==null && right==null) return  null;

        return left==null?right:left;
    }


    static boolean hasPath(TreeNode root, int nodeSearch, ArrayList<Integer> arrl){

        if(root==null)
            return false;

        arrl.add(root.data);

        if(nodeSearch==root.data){
            return true;
        }

        if(hasPath(root.left,nodeSearch,arrl) || hasPath(root.right, nodeSearch, arrl)){
            return true;
        }
        arrl.remove(arrl.size()-1);
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        TreeNode root=TreeNode.createMinimalBST(array);
        ArrayList<Integer> path1arr=new ArrayList<>();
        boolean path1=hasPath(root,1,path1arr);

        ArrayList<Integer> path2arr=new ArrayList<>();
        boolean path2=hasPath(root,10,path2arr);

        Iterator it1=path1arr.iterator();
        Iterator it2=path2arr.iterator();

        int anc=-1;
        if(path1 && path2) {
            while (it1.hasNext() && it2.hasNext()) {
                int a = (int) it1.next();
                int b = (int) it2.next();
                if (a != b) break;
                else anc = a;
            }

            System.out.println(anc);
        }else
        {
            System.out.println("Invalid Node values");
        }

        System.out.println("Without Extra Space");
        TreeNode ancnode=lca(root,10,7);
        System.out.println(ancnode.data);


    }

}
