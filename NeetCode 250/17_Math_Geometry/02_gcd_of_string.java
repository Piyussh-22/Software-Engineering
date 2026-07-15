// my first thought solution
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String originalStr2 = str2;

        while (str2.length() > 0) {
            String tempStr1 = str1;
            while (tempStr1.length() > 0) {
                if (tempStr1.startsWith(str2)) {
                    tempStr1 = tempStr1.substring(str2.length());
                } else {
                    break;
                }
            }
            if (tempStr1.length() == 0) {
                if (checkNewStr2(originalStr2, str2)) {
                    return str2;
                }
            }

            str2 = str2.substring(0, str2.length() - 1);
        }

        return "";
    }

    private boolean checkNewStr2(String originalStr2, String candidate) {
        while (originalStr2.length() > 0) {
            if (originalStr2.startsWith(candidate)) {
                originalStr2 = originalStr2.substring(candidate.length());
            } else {
                return false;
            }
        }
        return true;
    }
}

// optimized

/*

1071. Greatest Common Divisor of Strings
        Solved
Easy
        Topics
premium lock icon
        Companies
Hint
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""


Constraints:

        1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase
 letters.
 */