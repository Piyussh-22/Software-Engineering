package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _9_printduplicateonce {
    public static void main(String[] args) {
        int[] arr = {1,2,3,6,3,6,1};
        System.out.print(printDup(arr));

    }
    static List<Integer> printDup(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>() ;
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(Map.Entry<Integer,Integer> pair : map.entrySet()){
            if(pair.getValue() > 1){
                list.add(pair.getKey());
            }
        }
        return list;
    }
}
