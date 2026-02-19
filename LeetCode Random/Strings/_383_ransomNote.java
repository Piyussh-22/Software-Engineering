class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for(int i = 0 ; i < magazine.length() ; i++){
            freq[magazine.charAt(i)-'a']++;
        }
        for(int j = 0 ; j < ransomNote.length() ; j++){
            int idx = ransomNote.charAt(j)-'a';
            freq[idx]--;
            if(freq[idx] < 0){
                return false;
            }
        }
        return true;
    }
}