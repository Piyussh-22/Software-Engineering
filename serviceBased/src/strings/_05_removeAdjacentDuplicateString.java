package strings;

import java.util.*;
public class _05_removeAdjacentDuplicateString {
    public static void main(String[] args){
        System.out.println(delAdj("abbaca"));
    }
    static String delAdj(String s){
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != c ){
                stack.push(c);
            }else{
                stack.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        for(char c : stack){
            str.append(c);
        }
        return str.toString() ;
    }
}
