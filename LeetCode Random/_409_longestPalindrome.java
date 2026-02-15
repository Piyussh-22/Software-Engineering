class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        if(map.size() == 1) return s.length();
        boolean foundOdd = false;
        int answer = 0;
        for(int k : map.values()){
            if( k % 2 == 0 ){
                answer = answer + k;
            }else{
                answer = answer + (k/2)*2;
                foundOdd = true;
            }
        }
        if(foundOdd){
            answer = answer + 1;
        }
        return answer;
    }
}