package strings;

public class _18_detectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
    }
    static boolean detectCapitalUse(String word){
        int capitalCount = 0;
        // charArray create a new array in memory better will be for(i loop) using charAt(i)
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)){
                capitalCount++;
            }
        }
        return capitalCount == word.length() || capitalCount == 0 || (capitalCount == 1 && Character.isUpperCase(word.charAt(0)));

    }
}
