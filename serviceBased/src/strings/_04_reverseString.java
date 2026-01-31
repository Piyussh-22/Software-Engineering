package strings;

import java.util.*;
public class _04_reverseString {
    public static void main(String[] args){
        System.out.println(reverse("hello"));
    }
    static String reverse(String s){
        StringBuilder str = new StringBuilder();
        for (int i = s.length()-1 ; i >= 0 ; i--) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}
