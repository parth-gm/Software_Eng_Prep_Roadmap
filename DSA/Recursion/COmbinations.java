package code;

import java.util.*;

public class Question1 {

	/*
	Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.
		Input: n = 4, k = 2
		[1, 2, 3, 4]
		[1, 2]
		1
		2

Output:

[
[2,4],
[3,4],
[2,3],
[1,2],
[1,3],
[1,4],
]



	gck([1,2], 2)

	gck([1], 1)
	gck([], 0);
*/

    static List<List> results = new ArrayList<>(); //=> [[1, 2], [1,3]]

    public static void generateCombinationsOfK(int n, int k, List<Integer> sub, int j) {
        if(sub.size()==k)
        {
            System.out.println(sub);
//			results.add(sub);
            return;
        }

        for(int i=j;i<=n;i++) {
            sub.add(i);
            generateCombinationsOfK(n, k, sub, i+1);
            sub.remove(sub.size()-1);
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> sub = new ArrayList<>();
        int[] arr = {1, 2, 3, 4};

        generateCombinationsOfK(4, 3, sub, 1);
//		System.out.println(results);
    }

}
