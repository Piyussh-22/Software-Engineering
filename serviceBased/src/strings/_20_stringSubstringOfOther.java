package strings;

public class _20_stringSubstringOfOther {
    public static void main(String[] args) {
        System.out.println(cheakSubstring("piyush","sh"));
    }
    static int cheakSubstring(String s , String t){
        if(t.length() > s.length()) return -1;
        int loopLen = s.length() - t.length();
        for (int i = 0; i <= loopLen; i++) {
            if(s.startsWith(t,i)){
                return i;
            }
        }
        /*
        one line sol
        return s.indexOf(t);
        */
        return -1;
    }
}
