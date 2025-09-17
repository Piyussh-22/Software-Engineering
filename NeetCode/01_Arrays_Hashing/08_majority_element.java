class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        for(int k : nums){
            if(map.containsKey(k)){
                map.put(k,map.get(k)+1);
                if(map.get(k) > (nums.length/2)){
                    return k;
                }
            }else{
                map.put(k,1);
            }
        }
        return -1;  //unreachable code since majority element always exists.
    }
}



/*169. Majority Element
  Solved
  Easy
  Topics
  premium lock icon
  Companies
  Given an array nums of size n, return the majority element.

  The majority element is the element that appears more than ⌊n / 2⌋ times.
   You may assume that the majority element always exists in the array.



  Example 1:

  Input: nums = [3,2,3]
  Output: 3
  Example 2:

  Input: nums = [2,2,1,1,1,2,2]
  Output: 2


  Constraints:

  n == nums.length
  1 <= n <= 5 * 104
  -109 <= nums[i] <= 109


  Follow-up: Could you solve the problem in linear time and in O(1) space?*/