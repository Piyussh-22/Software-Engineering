package strings;

import java.util.*;

public class _08_characterFreqInString {
    public static void main(String[] args){
        System.out.println(freqCount("geeksforgeeks"));
    }
    static Map<Character,Integer> freqCount(String s){
        Map<Character,Integer> map = new LinkedHashMap<>();
        char[] arr = s.toCharArray();
        for(char c : arr){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        return map;
    }
}
