package arrays;

public class _20_longestContinuosIncSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(LCIS(nums));
        // nums's possible min length is 1
    }
    static int LCIS(int[] nums){
        int maxCount = 1;
        int count = 1;
        for (int i = 0 ; i < nums.length-1 ; i++){
            if(nums[i] < nums[i+1]){
                count++;
                maxCount = Math.max(count,maxCount);
            }else{
                count = 1;
            }
        }
        return maxCount;
    }
}

/*When a question asks for the longest contiguous (subarray)
 sequence where a condition must hold between adjacent elements,
 think: I’m tracking a
 running streak and resetting it when the condition breaks.*/
