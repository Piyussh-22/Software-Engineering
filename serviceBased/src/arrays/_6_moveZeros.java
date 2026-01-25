package arrays;

import java.util.Arrays;

public class _6_moveZeros {
    public static void main(String[] args) {
        int[] ans = {1,0,3,4,0,23,1};
        System.out.print(Arrays.toString(moveZeroes2(ans)));
    }
    static int[] moveZeroes(int[] nums) {
        int slow = 0;
        for(int fast = 0 ; fast < nums.length ; fast++){
            if(nums[fast] != 0){
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
        }
        return nums;
    }

    static int[] moveZeroes2(int[] nums){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        while(slow < nums.length){
            nums[slow] = 0;
            slow++;
        }
        return nums;
    }
}

/*283. Move Zeroes
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an integer array nums, move all 0's to the end of it
while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]


Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?*/
