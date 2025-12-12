import java.util.*;

public class Permutations {
    static void allPermutations(int[] nums, int idx, List<Integer> arrl){
        if(idx==nums.length)
        {
            System.out.println(arrl);
            return;
        }

        for(int j=0;j<arrl.size()+1;j++){
            arrl.add(j, nums[idx]);
            allPermutations(nums, idx+1, arrl);
            arrl.remove(j);
        }

    }
    static void main() {
        List<Integer> arrl = new ArrayList<>();
        int[] arr = {1, 2, 3, 4};
        allPermutations(arr, 0, arrl);
    }
}
