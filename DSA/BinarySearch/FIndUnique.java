package gfg;

/*
Given a sorted array where every element appears exactly twice, except for one element that appears only once, find
that single element.

 */
public class FindUnique {

    public static int bstUtil(int start, int end, int[] arr) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (((mid - 1) > 0 && arr[mid] == arr[mid - 1]) || ((mid + 1) < arr.length && arr[mid] == arr[mid + 1])) {
            int ans = bstUtil(mid + 1, end, arr);
            if (ans != -1) {
                return ans;
            }
            return bstUtil(start, mid - 1, arr);
        } else {
            return arr[mid];
        }
    }

    public static int solve(int[] A) {

        return bstUtil(0, A.length - 1, A);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};
        System.out.println(solve(arr));
    }

}
