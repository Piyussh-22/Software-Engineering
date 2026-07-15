// O(n2) (n sq solution)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int answer = 0;
        Set<Character> subChar = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            int count = 0;
            subChar.clear();
            for(int j = i ; j < s.length() ; j++){
                if(!subChar.contains(s.charAt(j))){
                    subChar.add(s.charAt(j));
                    count++;
                }else{
                    break;
                }

            }
            if(count > answer){
                answer = count;
            }
        }
        return answer;
    }
}

// 0(n) linear sol
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> subChar = new HashSet<>();
        int max = 0;
        int left = 0;
        for(int right = 0 ; right < s.length() ; right++){
            while(subChar.contains(s.charAt(right))){
                subChar.remove(s.charAt(left));
                left++;
            }
            subChar.add(s.charAt(right));
            max = Math.max( max, right-left+1 );
        }
        return max;
    }
}

/*3. Longest Substring Without Repeating Characters
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.*/