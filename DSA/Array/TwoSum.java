package leetcode;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] sols=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum=nums[i]+nums[j];
                if(sum==target)
                {
                    sols[0]=i;
                    sols[1]=j;
                    return  sols;
                }
            }
        }
        return sols;
    }

    public static int[] twoSumv1(int[] nums, int target) {
        int[] sols=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int j=0;j<nums.length;j++){
            if(map.containsKey(target-nums[j]) && map.get(target-nums[j])!=j){
                sols[0]=map.get(target-nums[j]);
                sols[1]=j;
                return sols;
            }
        }
        return sols;
    }

    public static int[] twoSumv2(int[] nums, int target) {
        int[] sols=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int j=0;j<nums.length;j++){
            if(map.containsKey(target-nums[j])){
                sols[0]=map.get(target-nums[j]);
                sols[1]=j;
                return sols;
            }
            map.put(nums[j],j);
        }
        throw new IllegalArgumentException("No two sum solution");
    }




    public static void main(String[] args) {
        int nums[]={ 2, 7, 11, 15};
        int[] sols=twoSumv2(nums,9);
        System.out.println(sols[0]+" "+sols[1]);
    }
}
