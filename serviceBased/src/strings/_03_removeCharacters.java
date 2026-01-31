package strings;

import java.util.*;

public class _03_removeCharacters {
    public static void main(String[] args){
        String a = "occurrence";
        String b = "car";
        System.out.println(removeChar(a,b));
    }
    /*
    static String removeChar(String a , String b){

    // blacklist characters from b
    int[] freq1 = new int[26];
    for(int i = 0 ; i < b.length() ; i++){
        char c = b.charAt(i);
        freq1[c - 'a'] = 1;
    }

    // build result by skipping blacklisted chars
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < a.length(); i++) {
        char c = a.charAt(i);
        if (freq1[c - 'a'] == 0) {
            str.append(c);
        }
    }

        return str.toString();
    }

     */

    /*static String removeChar(String a, String b) {

    // mark characters present in b
    boolean[] remove = new boolean[26];
    for (int i = 0; i < b.length(); i++) {
        remove[b.charAt(i) - 'a'] = true;
    }

    // build result by skipping marked chars
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < a.length(); i++) {
        char c = a.charAt(i);
        if (!remove[c - 'a']) {
            result.append(c);
        }
    }

    return result.toString();
}
*/
    static String removeChar(String a , String b){
        StringBuilder str = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(char c : b.toCharArray()){
            set.add(c);
        }
        for (int i = 0; i < a.length(); i++) {
            if(!set.contains(a.charAt(i))){
                str.append(a.charAt(i));
            }
        }
        return str.toString();
    }
}
