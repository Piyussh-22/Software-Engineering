class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int p1 = 0;
        int p2 = 0;
        for(int i = 0 ; i < t.length() ; i++){
            if(s.charAt(p1) == t.charAt(p2)){
                p1++;
                p2++;
                if(p1 == s.length()){
                    return true;
                }
            }else{
                p2++;
            }
        }
        return false;
    }
}