package strings;

import java.util.*;

public class _02_findCommonChar {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println((commonChars(words)));
    }

    static public List<String> commonChars(String[] words) {
        int[] freq = new int[26];
        for(int i = 0 ; i < words[0].length() ; i++){
            char c = words[0].charAt(i);
            freq[c-'a'] = freq[c-'a'] + 1 ;
        }
        for(int i = 1 ; i < words.length ; i++) {
            int[] currFreq = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                currFreq[c - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                freq[k] = Math.min(freq[k], currFreq[k]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int k = 0; k < 26; k++) {
            while(freq[k] > 0){
                char c = (char) (k+'a');
                String s = String.valueOf(c);
                ans.add(s);
                freq[k]--;
            }
        }
        return ans;

    }
}
