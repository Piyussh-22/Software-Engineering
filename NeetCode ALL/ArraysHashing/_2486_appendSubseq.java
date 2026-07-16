class Solution {
    public int appendCharacters(String s, String t) {
        int index = 0;
        for(char c : s.toCharArray()){
            if(index < t.length() && c == t.charAt(index)){
                index++;
            }
        }
        return t.length()-index;
    }
}