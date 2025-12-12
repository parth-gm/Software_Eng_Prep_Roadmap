package codeforces;

import java.util.Scanner;

/*
Given an array a of length n, count the number of quadruples of indices (i, j, k, l) such that i < j < k < l, a[i] =
a[k], and a[j] = a[l]. Each quadruple forms a zigzag pattern a[i] a[j] a[k] a[l] = x y x y. Return the total number
of such zigzag quadruples.
*/


public class Zigzags {


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
        }


    }

    static int findCombinations(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i <= (n - 4); i++) {
            int x = arr[i];
            for (int j = i + 1; j <= (n - 3); j++) {
                int y = arr[j];

                for (int k = j + 1; k <= (n - 2); k++) {

                    if (arr[k] == x) {

                        for (int l = k + 1; l <= (n - 1); l++) {
                            if (arr[l] == y) {
                                count++;
                            }
                        }

                    }

                }

            }
        }
        return count;

    }

}
