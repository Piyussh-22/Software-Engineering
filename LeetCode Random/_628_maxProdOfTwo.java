class Solution {
    public int maximumProduct(int[] nums) {
        int big = Integer.MIN_VALUE;
        int bigger = Integer.MIN_VALUE;
        int biggest = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int num : nums){
            if(num > biggest){
                big = bigger;
                bigger = biggest;
                biggest = num;
            }else if(num > bigger){
                big = bigger;
                bigger = num;
            }else if(num > big){
                big = num;
            }

            if(num < smallest){
                small = smallest;
                smallest = num;
            }else if(num < small){
                small = num;
            }
        }
        if(big * bigger * biggest > smallest * small * biggest){
            return big * bigger * biggest;
        }
        return smallest * small * biggest;
    }
}

/*
* 628. Maximum Product of Three Numbers
Solved
Easy
Topics
premium lock icon
Companies
Given an integer array nums, find three numbers whose product is maximum and return the maximum product.



Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6


Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000*/