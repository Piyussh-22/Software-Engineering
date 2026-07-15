package Strings;

class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder str = new StringBuilder();
        int count = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == '-') continue;
            if(count == k){
                str.append('-');
                count = 0;
            }
            str.append(Character.toUpperCase(c));
            count++;
        }
        return str.reverse().toString();
    }
}
