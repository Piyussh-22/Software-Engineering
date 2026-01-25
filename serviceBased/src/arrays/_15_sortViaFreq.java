package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _15_sortViaFreq {
    public static void main(String[] args) {
        int[] ans = sort(new int[]{5,5,4,6,4});
        System.out.print(Arrays.toString(ans));
    }
    static int[] sort(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for (int k : arr) {
            if(map.containsKey(k)){
                map.put(k,map.get(k)+1);
            }else{
                map.put(k,1);
            }
        }
        //i don't know how to sort a hashmap
        int[] ans = new int[arr.length];
        return ans;
    }
}
