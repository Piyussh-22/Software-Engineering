package strings;
import java.util.*;
public class _09_sortStringOfCharacters {
    public static void main(String[] args){
        System.out.println(array("geeksforgeeks"));
    }
    static String sort(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    static String array(String s){
        int[] arr = new int[26];
        for(char c : s.toCharArray()){
            int index = c - 'a';
            arr[index]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < arr.length ; i++){
            while(arr[i] > 0) {
                sb.append((char) (i + 'a'));
                arr[i]--;
            }
        }
        return sb.toString();
    }
}
