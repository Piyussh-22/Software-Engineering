package Sort_Cyclic;

class E_645_Set_mismatch {
    public int[] findErrorNums(int[] nums) {
        int i = 0 ;
        int n = nums.length;
        while(i < n){
            int Ci = nums[i] - 1 ;
            if(Ci < n && nums[i] != nums[Ci]){
                int temp = nums[i];
                nums[i] = nums[Ci];
                nums[Ci] = temp;
            }else{
                i++;
            }
        }
        int[] ans = new int[2];
        for(int j = 0 ; j < n ; j++){
            if(nums[j] != j+1){
                ans[0] = nums[j];
                ans[1] = j+1;
                return ans;
            }
        }
        return ans; //Not reachable 
    }
}

/*645. Set Mismatch
Solved
Easy
Topics
premium lock icon
Companies
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.



Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]


Constraints:

2 <= nums.length <= 104
1 <= nums[i] <= 104*/