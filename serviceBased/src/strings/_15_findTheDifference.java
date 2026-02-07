package strings;

public class _15_findTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("","a"));
    }
    static char findTheDifference(String s, String t){
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < t.length() ; i++){
            arr[t.charAt(i)-'a']--;
        }
        for(int i = 0 ; i < t.length() ; i++){
            if(arr[i] != 0){
                return (char)(i+ 'a');
            }
        }
        return ' ';
    }
}
