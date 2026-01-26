package arrays;

import java.util.Arrays;

public class _17_nextGreaterElement {
    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }
    // Function to find next greater elements
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int p = nums1.length;
        int q = nums2.length;
        int[] ans = new int[p];

        for (int i = 0; i < p; i++) {
            int val = nums1[i];
            ans[i] = -1; // default

            for (int j = 0; j < q; j++) {
                if (val == nums2[j]) {
                    for (int k = j + 1; k < q; k++) {
                        if (nums2[k] > val) {
                            ans[i] = nums2[k];
                            break;
                        }
                    }
                    break; // stop searching nums2
                }
            }
        }
        return ans;
    }
}
