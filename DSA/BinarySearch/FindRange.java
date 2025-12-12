package errichto;

import java.util.Arrays;

public class BSQuestion {

    public static int firstPosition(int[] nums,int p) {


        int left=0,right=nums.length-1;
        int frontIdx=nums.length;
        while(left<=right) {
            int mid=(left+right)/2;
            if(nums[mid]>=p) {
                frontIdx=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        System.out.println(left+" "+right);
        return frontIdx;


    }


    public static int[] searchRange(int[] nums, int target) {
        int[] range=new int[2];
        Arrays.fill(range,-1);
        int start=firstPosition(nums, target);



        int end=firstPosition(nums, target+1)-1;
        if(start>end) return range;

        range[0]=start;
        range[1]=end;
        return range;

    }

    public static void main(String[] args) {

        int[] nums= {5,7,7,8,8,10};
        int[] range=searchRange(nums,11);
        System.out.println(range[0]+" "+range[1]);


    }

}
