// string style 1
class Solution {
    public boolean isHappy(int n) {
        String test = Integer.toString(n);
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        while (sum != 1){
            sum = 0;
            for (int i = 0; i < test.length(); i++) {
                int temp = test.charAt(i) - '0';
                sum = sum + (temp * temp);
            }
            if(sum != 1){
                if(!set.contains(sum)){
                    set.add(sum);
                    test = Integer.toString(sum);
                }else{
                    return false;
                }
            }else{
                break;
            }
        }
        return true;
    }
}
// string style2
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        String numStr = Integer.toString(n);
        while (true){
            int sum = 0;
            for (int i = 0; i < numStr.length(); i++) {
                int digit = numStr.charAt(i) - '0';
                sum += (digit * digit);
            }
            if(sum==1){
                return true;
            }
            if(seen.contains(sum)){
                return false;
            }
            seen.add(sum);
            numStr = Integer.toString(sum);
        }
    }
}
//% way
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (true){
            int sum = 0;
            while(n>0){
                int x = n % 10;
                sum += (x*x);
                n /= 10;
            }
            if(sum==1){
                return true;
            }
            if(seen.contains(sum)){
                return false;
            }
            seen.add(sum);
            n = sum;
        }
    }
}


/*202. Happy Number
Solved
Easy
Topics
premium lock icon
Companies
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it
loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1*/