package ArraysHashing;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int k : arr){
            map.put(k , map.getOrDefault(k,0)+1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int k : map.values()){
            if(!set.add(k)){
                return false;
            }
        }
        return true;
    }
}