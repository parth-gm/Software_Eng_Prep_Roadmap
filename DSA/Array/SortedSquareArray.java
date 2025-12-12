package Array;

public class SortedSquareArray {

    static int[] findSortedSquare(int[] arr){

        int left=0,right=arr.length-1;
        int[] res=new int[arr.length];
        int idx=arr.length-1;
        while (right>=left && idx>=0){
            if(Math.abs(arr[left])>Math.abs(arr[right])){
                res[idx--]=arr[left]*arr[left];
                left++;
            }else{
                res[idx--]=arr[right]*arr[right];
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr={-7,-3,-1,4,8,12};
        //int[] arr={};

        int result[]=findSortedSquare(arr);

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }


}
