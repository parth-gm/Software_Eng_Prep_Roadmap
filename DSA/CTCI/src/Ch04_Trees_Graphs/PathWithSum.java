package Ch04_Trees_Graphs;

public class PathWithSum {

    static  void printPath(int[] patharr,int len){
        for(int i=0;i<len;i++)
            System.out.print(patharr[i]+" ");
        System.out.println();
    }

    /*static void printAllPathRecur(TreeNode root,int[] patharr,int pathlen){

        if(root==null)return;

        patharr[pathlen]=root.data;
        pathlen++;

        if(root.left==null && root.right==null)
            printPath(patharr,pathlen);

        else{
            printAllPathRecur(root.left,patharr,pathlen);
            printAllPathRecur(root.right,patharr,pathlen);
        }

    }*/
    static void printAllPathRecur(TreeNode root,int[] patharr,int pathlen,int sum,int findsum){

        if(root==null)return;

        patharr[pathlen]=root.data;
        sum=sum+root.data;
        pathlen++;

        if(sum==findsum)
            printPath(patharr,pathlen);

        else{
            printAllPathRecur(root.left,patharr,pathlen,sum,findsum);
            printAllPathRecur(root.right,patharr,pathlen,sum,findsum);
        }

    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,2,1};
        TreeNode root=TreeNode.createMinimalBST(array);
        int[] arr=new int[100];
        int findsum=6;

        printAllPathRecur(root,arr,0,0,findsum);
    }
}
