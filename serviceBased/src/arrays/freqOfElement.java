package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class freqOfElement {
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                        countFreq(new int[]{1,2,2,3,3,3,3,4}).toArray()
                )
        );

        ArrayList<int[]> result = countFreq(new int[]{1,2,2,3,3,3,3,4});
        for (int[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }

    }
    static ArrayList<int []> countFreq(int [] nums) {
        ArrayList<int[]> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int k : nums){
            if(map.containsKey(k)){
                map.put(k,map.get(k)+1);
            }else{
                map.put(k,1);
            }
        }

        for(HashMap.Entry<Integer,Integer> entry : map.entrySet()){
            int[] pair = new int[2];
            pair[0] = entry.getKey();
            pair[1] = entry.getValue();
            ans.add(pair);
        }
        return ans;
    }
}

/*Given an array arr[] of non-negative integers which may contain duplicate elements.
Return the frequency of each distinct00 element present in the array.*/