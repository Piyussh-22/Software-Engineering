// M1 (Brute Force)
// Time: O(n + q * k), Worst Case: O(n * q)
// Space: O(n)
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] isVowel = new int[words.length];
        int i = 0;
        for(String word : words){
            if("aeiou".indexOf(word.charAt(0)) != -1 && "aeiou".indexOf(word.charAt(word.length()-1)) != -1 ){
                isVowel[i] = 1;
            }else{
                isVowel[i] = 0;
            }
            i++;
        }

        int[] answer = new int[queries.length];
        int k = 0;
        for(int[] arr : queries){
            int sum = 0;
            for(int j = arr[0] ; j <= arr[1] ; j++){
                sum = sum + isVowel[j];
            }
            answer[k] = sum;
            k++;
        }
        return answer;
    }
}

// M2 (Prefix Sum)
// Time: O(n + q)
// Space: O(n)
class Solution2 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            prefix[i] = ("aeiou".indexOf(word.charAt(0)) != -1 &&
                         "aeiou".indexOf(word.charAt(word.length() - 1)) != -1) ? 1 : 0;

            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l == 0) {
                answer[i] = prefix[r];
            } else {
                answer[i] = prefix[r] - prefix[l - 1];
            }
        }

        return answer;
    }
}

