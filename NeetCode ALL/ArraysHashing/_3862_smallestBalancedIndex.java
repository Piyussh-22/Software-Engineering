class Solution {
    public int smallestBalancedIndex(int[] nums) {
        double sum = 0;
        double pro = 1;
        int ans = -1;

        for(int i = 0; i < nums.length - 1; i++){
            sum += nums[i];
        }

        for(int i = nums.length - 1; i >= 0; i--){
            if(sum == pro){
                ans = i;
            }

            if(i > 0){
                sum -= nums[i-1];
            } else {
                sum = 0;
            }

            pro *= nums[i];

            if(pro > sum) break;
        }

        return ans;
    }
}