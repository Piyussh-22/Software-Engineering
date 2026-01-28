package strings;

import java.util.Locale;

public class _01_palindrome {
    public static void main(String[] args) {
        String input = "poop";
        System.out.println(isPalin(input));
    }
    static boolean isPalin(String input){
        int n = input.length();
        input = input.toLowerCase();
        for (int i = 0; i < n/2; i++) {
            if(input.charAt(i) != input.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }
}

