package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] ans = map(new int[]{3,2,4},6);
        System.out.println(Arrays.toString(ans));
    }
    static int[] loop(int[] nums,int target){
        int[] ans = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
        //time n sq -- space auxiliary space = constant
    }

    static int[] map(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // if no solution
    }
}
/*[I@7b23ec81  java default way to print array reference
* [ its a array
* I type is int
* @ separator
* 7b23ec81 Hashcode in hexadecimal
*
* its not real memory address , not values ,
* just reference identity string
* */

