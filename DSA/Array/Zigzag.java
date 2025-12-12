package arrays;

import java.util.HashMap;
import java.util.Scanner;

/*
Problem Statement (Zigzag Pairs / Counting Zigzags)

You are given an array arr of size N.

Find the number of quadruples (i, j, k, l) such that:

i < j < k < l
arr[i] == arr[k]
arr[j] == arr[l]


This pattern is known as a Zigzag:

A B A B


Example:

arr = [1, 2, 1, 2]

Valid zigzag:
i=0, j=1, k=2, l=3  →  1 2 1 2
Count = 1


Your code computes how many such (i, j, k, l) exist in the array.
 */
public class Zigzag {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int noTest = sc.nextInt();
        for (int i = 0; i < noTest; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }
            System.out.println(findCombinations(arr, N));
            //System.out.println(""+2+3);
        }


    }

    static long findCombinations(int[] arr, int n) {

        if (n < 4) {
            return 0;
        }
        HashMap<Integer, Long> lsum = new HashMap<>();
        long count = 0;
        for (int i = 0; i <= n - 2; i++) {
            HashMap<Integer, Long> rsum = new HashMap<>();

            for (int j = n - 1; j > i; j--) {

                if (rsum.containsKey(arr[i]) && lsum.containsKey(arr[j])) {
                    count = count + (rsum.get(arr[i]) * lsum.get(arr[j]));
                }
                if (!rsum.containsKey(arr[j]))
                    rsum.put(arr[j], (long) 1);
                else {
                    rsum.put(arr[j], rsum.get(arr[j]) + 1);
                }

            }

            if (!lsum.containsKey(arr[i]))
                lsum.put(arr[i], (long) 1);
            else
                lsum.put(arr[i], lsum.get(arr[i]) + 1);

        }

        return count;
    }
}