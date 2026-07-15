package Sort_Cyclic;

class E_268_missingnumber {
    public int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int corrIndex = nums[i];
            if(corrIndex < nums.length && nums[corrIndex] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[corrIndex];
                nums[corrIndex] = temp;
            }else{
                i++;
            }
        }
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] != j){
                return j;
            }
        }
        return nums.length;
    }
} 