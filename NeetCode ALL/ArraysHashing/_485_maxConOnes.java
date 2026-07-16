class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentMax = 0;
        int max = 0;
        for(int k : nums){
            if(k == 1){
                currentMax++;
                if(currentMax > max){
                    max = currentMax;
                }
            }else{
                currentMax = 0;
            }
        }
        return max;
    }
}