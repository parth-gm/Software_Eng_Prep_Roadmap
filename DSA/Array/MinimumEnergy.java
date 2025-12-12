package gfg;

import java.util.Scanner;

/*
You are given an array of integers arr[] of length n.

Each element represents energy gained or lost at step i.

You start with some initial energy E (unknown).

Your energy must always stay positive (> 0) as you traverse the array.

Goal: Find the minimum initial energy E so that the energy never becomes zero or negative while iterating the array.

🔍 Example

Array: [ -3, 2, -3, 4, 2 ]

Step 1: Start with E → E - 3

Step 2: Add 2 → E - 1

Step 3: Add -3 → E - 4 (must stay positive!)

…

You need to find the smallest E that keeps cumulative sum > 0 at all times.

 */
public class MinimumEnergy {

    static int findMinimumEnergy(int[] arr, int noEle) {

        int currentTotal = 0;
        int startEnergy = 0;
        for (int i = 0; i < noEle; i++) {
            currentTotal = currentTotal + arr[i];

            if (currentTotal <= 0) {
                startEnergy = startEnergy + (((-1) * currentTotal) + 1);
                currentTotal = 1;
            }

        }
        return startEnergy == 0 ? 1 : startEnergy;

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int noTest = sc.nextInt();
        for (int i = 0; i < noTest; i++) {

            int noEle = sc.nextInt();
            int[] arr = new int[noEle];
            for (int j = 0; j < noEle; j++) {

                arr[j] = sc.nextInt();
            }

            System.out.println(findMinimumEnergy(arr, noEle));

        }


    }

}
