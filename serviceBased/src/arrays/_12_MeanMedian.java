package arrays;

import java.util.Arrays;

public class _12_MeanMedian {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,5};
        float[] ans = meanMedian(arr);
        System.out.println(Arrays.toString(ans));

    }
    static float[] meanMedian(int[] arr) {
        int[] sorted = arr.clone();
        float[] ans = new float[2];

        // bubble sort
        boolean swap;
        for (int j = 0; j < sorted.length - 1; j++) {
            swap = false;
            for (int i = 0; i < sorted.length - 1 - j; i++) {
                if (sorted[i] > sorted[i + 1]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i + 1];
                    sorted[i + 1] = temp;
                    swap = true;
                }
            }
            if(!swap) break;
        }

        float sum = 0;
        for (int k : sorted) {
            sum += k;
        }
        ans[0] = sum / sorted.length;

        int mid = sorted.length / 2;
        if (sorted.length % 2 == 0) {
            ans[1] = (sorted[mid] + sorted[mid - 1]) / 2f;
        } else {
            ans[1] = sorted[mid];
        }

        return ans;
    }

}
