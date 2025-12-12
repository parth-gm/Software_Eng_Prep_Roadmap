import java.util.*;

public class MainClass {

	/*
	    Problem Statement: Merge K Consecutive Characters

        Given:

        An integer k

        A string str

        You must repeatedly remove every group of k consecutive identical characters from the string.
        After removal, if new groups of k are formed, they should also be removed.

        Return the final string after all possible removals.

        🎯 Goal

        Implement a function:

        static String mergeKConsicutiveChars(int k, String str)


        that removes groups of k identical consecutive characters.

        📝 Example
        Input:
        k = 3
        str = "abbccc"

        Process:

        "ccc" → has 3 consecutive c’s → remove → remaining: "abb"

        "bb" → only 2 → keep

        "a" → keep

        Output:
        "abb"
	 */


    static String mergeKConsicutiveChars(int k, String str) {

        Stack<Pair> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (stack.isEmpty()) {
                stack.add(new Pair(str.charAt(i), 1));
            } else {

                Pair prevPair = stack.peek();
                if (str.charAt(i) == prevPair.ch) {
                    prevPair.freq += 1;
                    if (prevPair.freq != k) {
                        stack.pop();
                        stack.add(prevPair);
                    } else {
                        stack.pop();
                    }

                } else {
                    stack.add(new Pair(str.charAt(i), 1));
                }
            }

        }
        System.out.println(stack);
        StringBuilder sbuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair curPair = stack.pop();
            while (curPair.freq-- > 0) {
                sbuilder.append(curPair.ch);
            }
        }

        return sbuilder.reverse().toString();


    }

    static class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public String toString() {
            return "(" + ch + "," + freq + ")";
        }

    }

    public static void main(String[] args) {

        System.out.println(mergeKConsicutiveChars(3, "abbccc"));

    }

}
