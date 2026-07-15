class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int answer = -1;
        int gap = Integer.MAX_VALUE;
        for(int i = capacity.length-1 ; i >= 0 ; i--){
            if(capacity[i] >= itemSize){
                if(capacity[i] - itemSize <= gap){
                    gap = capacity[i] - itemSize;
                    answer = i;
                }
            }
        }
        return answer;
    }
}