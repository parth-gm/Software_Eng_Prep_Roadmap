package leetcode_july;

import java.util.Arrays;
import java.util.Comparator;

/*

Queue Reconstruction by Height

You are given an array people where each element is:

people[i] = [hi, ki]


hi = height of the person

ki = number of people in front of them who have height ≥ hi

Your task is to reconstruct the queue that satisfies this condition.

Example:

Input:

[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]


Output:

[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 */
public class QueueReconstruction {

    public static int[][] reconstructQueue(int[][] people) {


        Arrays.sort(people, new Comparator<int[]>() {

            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] > p2[0]) {
                    return 1;
                } else if (p1[0] == p2[0]) {
                    if (p1[1] > p2[1])
                        return 1;
                    else
                        return -1;
                } else {
                    return -1;
                }
            }
        });
        int output[][] = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            Arrays.fill(output[i], -1);
        }
        //System.out.println(output[0].length);
        for (int i = 0; i < people.length; i++) {
            int[] selectedPeople = people[i];
            int counter = selectedPeople[1];
            for (int j = 0; j < people.length; j++) {

                if (counter == 0 && output[j][0] == -1) {
                    output[j] = selectedPeople;
                    break;
                }

                if (output[j][0] != -1) {
                    if (output[j][0] >= selectedPeople[0]) {
                        counter--;
                    }

                } else {
                    counter--;

                }
                if (counter < 0)
                    counter = 0;


            }


        }


        return output;

    }


    public static void main(String[] args) {
        int[][] input = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        int[][] op = reconstructQueue(input);

        for (int i = 0; i < op.length; i++) {
            System.out.println(op[i][0] + " " + op[i][1]);
        }

    }

}
