package Sort_Cyclic;

class E_448_findallnumbersdisappearedinarray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0 ; i < nums.length ;i++){
            int Ci = Math.abs(nums[i]) - 1 ;
            if(nums[Ci] > 0){
                nums[Ci] = -nums[Ci];
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int j = 1 ; j <= nums.length ; j++){
            if(nums[j-1] > 0){
                list.add(j);
            }
        }
        return list;
    }
}