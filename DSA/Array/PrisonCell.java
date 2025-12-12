package leetcode_july;

import java.util.Arrays;

/*
✅ Problem Statement (LeetCode 957)
Prison Cells After N Days

There are 8 prison cells in a row, and each cell can be either occupied (1) or empty (0).

Every day, the cells change according to this rule:

A cell becomes 1 (occupied) only if its left and right neighbors are both occupied or both empty.

Otherwise, the cell becomes 0.

The first and last cells (index 0 and 7) always become 0, because they have only one neighbor.

Given:

int[] cells → the initial state (size = 8)

int N → number of days

Return the state of the prison after N days.

Example:
Input:
cells = [0,1,0,1,1,0,0,1]
N = 7

Output:
[0,0,1,1,0,0,0,0]
 */

public class PrisonCell {

    public static int[] generateNextDay(int[] nowDay) {

        int[] nextDay = new int[8];
        for (int j = 1; j < 7; j++) {

            if (nowDay[j - 1] == nowDay[j + 1]) {
                nextDay[j] = 1;
            }

        }
        return nextDay;

    }

    public static int[] prisonAfterNDays(int[] cells, int N) {

        for (int i = 0; i < N; i++) {
            cells = generateNextDay(cells);
        }
        return cells;
    }

    public static void main(String[] args) {

        int[] cells = {0, 1, 0, 1, 1, 0, 0, 1};
        int N = 7;
        System.out.println(Arrays.toString(prisonAfterNDays(cells, N)));
//		Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
//				Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
    }

}
