package hackerrank;

/*
Gary is hiking a trail.

You are given:

n → number of steps

s → a string describing the path

'U' = step Up

'D' = step Down

He starts at sea level (0).

A valley is defined as:

👉 A sequence of consecutive steps below sea level, starting with a step down and ending when he returns to sea level.

Goal:
Count how many valleys he walks through.
 */
public class CountingVelly {

    static int countingValleys(int n, String s) {

        int level = 0, velly = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'U') {
                level++;
                if (level == 0)
                    velly++;

            } else {
                level--;

            }


        }
        return velly;


    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }

}
