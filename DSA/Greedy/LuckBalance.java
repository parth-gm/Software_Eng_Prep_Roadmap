package hackerrank;

import java.util.ArrayList;
import java.util.Collections;

/*

Problem Statement:

Lena has n contests. Each contest has:

luck[i] — amount of luck she gains or loses

importance[i] — 1 if contest is important, 0 if not important

Rules:

If Lena loses a contest → she gains luck.

If Lena wins a contest → she loses that luck.

She can choose to lose at most k important contests.

She can lose any number of unimportant contests.

Goal:
Maximize the total luck Lena can have after all contests.

Input:

k: number of important contests she is allowed to lose

contests: matrix where each row = [luck, importance]

Output:

Maximum luck Lena can accumulate

 */

public class LuckBalance {

    static int luckBalance(int k, int[][] contests) {

        int luck = 0;
        ArrayList<Integer> arrl = new ArrayList<Integer>();

        for (int i = 0; i < contests.length; i++) {

            if (contests[i][1] == 0) {
                luck = luck + contests[i][0];
            } else {
                arrl.add(contests[i][0]);
            }

        }
        Collections.sort(arrl, Collections.reverseOrder());

        for (int imp : arrl) {

            if (k-- > 0) {
                luck = luck + imp;
            } else {
                luck = luck - imp;
            }

        }

        return luck;

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] contests = {{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}};

        System.out.println(luckBalance(3, contests));


    }

}
