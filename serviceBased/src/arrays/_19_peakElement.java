package arrays;

public class _19_peakElement {
    public static void main(String[] args){
        System.out.println(peak(new int[]{1,2,3,1}));
        System.out.println(peakBS(new int[]{1,2,3,1}));
    }
    /*When a problem talks about neighbors,
     think local comparison and edge handling*/
    static int peak(int[] nums){
        int n = nums.length;
        //empty array
        if(n == 0) return -1;

        // single element
        if (n == 1) return 0;

        //first element
        if(nums[0] > nums[1]) return 0;

        //middle element
        for (int i = 1 ; i < n-1 ; i++){
            if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                return i;
            }
        }

        //if no peak found till now last index is peak
        return n-1;
    }

    //need improvement
    static int peakBS(int[] nums){
        int n = nums.length;
        //single element
        if (n == 1) return 0;

        //first element
        if(nums[0] > nums[1]) return 0;

        //last element
        if(nums[n-1] > nums[n-2]) return n-1;

        int low = 1;
        int high = n-2;
        while(low <= high){
            int mid = low + (high - low) / 2 ;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            } else if (nums[mid] < nums[mid+1]) {
                low = mid + 1;
            } else if (nums[mid] < nums[mid-1]) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
