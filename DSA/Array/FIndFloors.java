/*
Given a building with N floors and Q elevator operations, each operation consists of two integers A and B. The
elevator always starts at floor 0. For each operation, the elevator first moves to floor A and then moves to
floor B. Calculate the total number of floors the elevator travels after performing all operations in order.
*/

package codechef;
import java.util.*;

import java.lang.*;
import java.io.*;

class Codechef2
{

    static int findTotalFloor(int N,int Q,int[][] array) {

        int total=0,current=0;

        for(int i=0;i<Q;i++) {
            total=total+Math.abs(current-array[i][0]);
            current=array[i][0];
            total=total+Math.abs(current-array[i][1]);
            current=array[i][1];
        }
        return total;

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int notest=sc.nextInt();
        int array[][];
        for(int i=0;i<notest;i++) {
            int N=sc.nextInt();
            int Q=sc.nextInt();
            array=new int[Q][2];
            for(int j=0;j<Q;j++) {
                array[j][0]=sc.nextInt();
                array[j][1]=sc.nextInt();
            }

            System.out.println(findTotalFloor(N,Q,array));

        }

    }


}
