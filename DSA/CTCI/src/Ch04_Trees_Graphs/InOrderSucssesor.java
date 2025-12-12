package Ch04_Trees_Graphs;

public class InOrderSucssesor {

    static  TreeNode find(TreeNode root,int data){
        TreeNode itr=root;
        while(itr!=null)
        {
            if(itr.data<data)
                itr=itr.right;
            else if(itr.data>data)
                itr=itr.left;
            else
                break;
        }
        return  itr;
    }

    static  TreeNode findMin(TreeNode root){
        TreeNode nodeRight=root;
        while(nodeRight.left!=null) {
            nodeRight=nodeRight.left;
        }
        return nodeRight;
    }

    static TreeNode getSuccesor(TreeNode root,int data){
        TreeNode current=find(root,data);
        if(current == null) return null;
        if(current.right!=null) {
            return findMin(current.right);
        }
        else {

            TreeNode successor=null;
            TreeNode ancestor=root;

            while(ancestor!=current){
                if(current.data<ancestor.data){
                    successor=ancestor;
                    ancestor=ancestor.left;
                }else{
                    ancestor=ancestor.right;
                }
            }
            return  successor;

        }
    }


    static int nextInOrder(TreeNode root) {

        if(root.right!=null) {
            TreeNode nodeRight=root.right;
            while(nodeRight.left!=null) {
                nodeRight=nodeRight.left;
            }
            return nodeRight.data;
        }
        else {
                TreeNode nodeParent=root.parent;
                while(nodeParent.data<root.data) {
                    nodeParent=nodeParent.parent;
                    if(nodeParent==null){
                        break;
                    }
                }
            if (nodeParent != null) {
                return nodeParent.data;
            }


        }
        return -1;

    }

    //Take O(N)
    static  void printInorder(TreeNode root,int[] arr){

        if(root==null)
            return;

        printInorder(root.left,arr);
        arr[getIncrement.value()]=root.data;
        printInorder(root.right,arr);
    }

    public static void main(String[] args) {

        int[] arr={1,2,3,4,5,6,7,8,9};
        //TreeNode root=TreeNode.createMinimalBST(arr);
        //int[] inorserArr=new int[arr.length];
        int[] inorserArr=new int[11];



        TreeNode left=new TreeNode(10);
        TreeNode right=new TreeNode(20);

        TreeNode root=new TreeNode(left,15,right);
        left.parent=root;
        right.parent=root;

        left.left=new TreeNode(null,8,null,left);
        left.right=new TreeNode(null,12,null,left);


        right.left=new TreeNode(null,17,null,right);
        right.right=new TreeNode(null,25,null,right);


        printInorder(root,inorserArr);
        System.out.println("Inorder Traversal Seq: ");
        for(int j=0;j<7;j++){
            System.out.println(inorserArr[j]);
        }

       // System.out.println("InOrder after: "+getSuccesor(root,8).data);

        TreeNode opNode=getSuccesor(root,8);
        if(opNode!=null)
            System.out.println("InOrder after: "+opNode.data);
        else
            System.out.println("Last Element Inorder : No Sucessor: "+opNode.data);
        //        System.out.println("Parent: "+left.right.parent.data);

        //        System.out.println("Enter node to get Inorder Successor: ");
        //        int x=9;
        //        for(int i=0;i<arr.length;i++){
        //            if(inorserArr[i]==x){
        //                if(i==arr.length-1){
        //                    System.out.println("No Inorder Sucessor "+null);
        //                }else {
        //                    System.out.println("INORDER Sucessor: " + inorserArr[++i]);
        //                }
        //                break;
        //            }
        //        }

    }

}
