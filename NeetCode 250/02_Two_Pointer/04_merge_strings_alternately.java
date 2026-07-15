class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int len = word1.length() + word2.length();
        int start1 = 0;
        int start2 = 0;
        for(int i = 0 ; i < len ; i++){
            if(start1<word1.length()){
                ans.append(word1.charAt(start1));
                start1++;
            }
            if(start2<word2.length()){
                ans.append(word2.charAt(start2));
                start2++;
            }
        }
        return ans.toString();
    }
}

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        int start1 = 0;
        int start2 = 0;
        while(start1<word1.length() || start2<word2.length()){
            if(start1<word1.length()) ans.append(word1.charAt(start1++));
            if(start2<word2.length()) ans.append(word2.charAt(start2++));
        }
        return ans.toString();
    }
}

/*1768. Merge Strings Alternately
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.



Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d


Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.*/