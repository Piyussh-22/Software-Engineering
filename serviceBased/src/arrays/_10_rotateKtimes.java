package arrays;

import java.util.Arrays;

public class _10_rotateKtimes {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(rotateK(new int[]{1,2,3,4,5} , 2)));
    }
    static int[] rotateK(int[] arr, int k){
        int len = arr.length;
        k = k % len;if (k == 0 ) return arr;
        while(k > 0){
            int last = arr[len-1];
            for (int i = len-1 ; i > 0; i--) {
                arr[i] = arr[i-1];
            }
            arr[0] = last;
            k--;
        }
        return arr;
    }
}
