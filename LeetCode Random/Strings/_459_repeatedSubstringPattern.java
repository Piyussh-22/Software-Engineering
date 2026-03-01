class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String twoS = s+s;
        return twoS.substring(1,twoS.length()-1).contains(s);
    }
}