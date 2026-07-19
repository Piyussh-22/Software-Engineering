import java.util.*;
class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] on = new boolean[101];
        for(int k : bulbs){
            on[k] = !on[k];
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= 100 ; i++){
            if(on[i]){
                list.add(i);
            }
        }
        return list;
    }
}