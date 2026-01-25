package arrays;

import java.util.Arrays;

public class _13_1stand2ndSmallest {
    public static void main(String[] args) {
        int[] arr = {2,1,1};
        int[] ans = findSmallest(arr);
        System.out.println(Arrays.toString(ans));
    }

    static int[] findSmallest(int[] arr) {
        if (arr.length < 2) {
            return new int[]{-1, -1};
        }
        int small1st = Integer.MAX_VALUE;
        int small2nd = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < small1st) {
                small2nd = small1st;
                small1st = arr[i];
            }
            else if (arr[i] > small1st && arr[i] < small2nd) {
                small2nd = arr[i];
            }
        }
        if (small2nd == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return new int[]{small1st, small2nd};
    }
}
