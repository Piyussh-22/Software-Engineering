package strings;

import java.util.*;
public class _06_uncommonWordsfromTwoSentences {
    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences(s1,s2)));
    }
    static public String[] uncommonFromSentences(String s1, String s2) {
        Map<String , Integer> map = new HashMap<>();
        for(String word : s1.split(" ")){
            map.put(word , map.getOrDefault(word,0) + 1);
        }
        for(String word : s2.split(" ")){
            map.put(word , map.getOrDefault(word,0) + 1);
        }
        List<String> list = new ArrayList<>();
        for(String word : map.keySet()){
            if(map.get(word) == 1){
                list.add(word);
            }
        }
        return list.toArray(new String[0]);
    }
}
