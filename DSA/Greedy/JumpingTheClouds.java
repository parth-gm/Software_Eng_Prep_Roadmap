package hackerrank;


/*

Question (HackerRank – Jumping on the Clouds)

You are given an array of clouds:

0 → safe cloud

1 → thundercloud (must be avoided)

You start at cloud index 0 and want to reach the last cloud.

Rules:

You can jump:

1 cloud, or

2 clouds at a time.

You must avoid landing on a thundercloud (value 1).

Your goal is to minimize the total number of jumps it takes to reach the end.

Input Example:
c = [0, 1, 0, 0, 0, 1, 0]

Output Example:
4
 */
public class JumpingTheClouds {

    static int jumpingOnClouds(int[] c) {
        int jump = 0;
        int current = 0;
        while (current < (c.length - 1)) {

            if ((current + 2) < c.length && c[current + 2] == 0) {
                current = current + 2;
            } else if ((current + 1) < c.length && c[current + 1] == 0) {
                current = current + 1;
            }
            jump++;
        }
        return jump;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] c = {0, 1, 0, 0, 0, 1, 0};
        int x = jumpingOnClouds(c);
        System.out.println(x);


    }

}
