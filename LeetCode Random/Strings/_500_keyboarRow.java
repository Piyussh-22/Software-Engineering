class Solution {
    public String[] findWords(String[] words) {

        int[] arr = new int[26];

        for(char c : "qwertyuiop".toCharArray()) arr[c-'a'] = 1;
        for(char c : "asdfghjkl".toCharArray()) arr[c-'a'] = 2;
        for(char c : "zxcvbnm".toCharArray()) arr[c-'a'] = 3;

        List<String> answer = new ArrayList<>();

        for(String word : words){

            String s = word.toLowerCase();
            int row = arr[s.charAt(0)-'a'];

            int i = 1;
            while (i < s.length() && arr[s.charAt(i)-'a'] == row) {
                i++;
            }

            if(i == s.length()){
                answer.add(word);
            }
        }
        return answer.toArray(new String[0]);
    }
}