package Strings;

class Solution {
    public String reverseVowels(String s) {

        Set<Character> vowels =
                Set.of('a','e','i','o','u','A','E','I','O','U');

        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            char l = arr[left];
            char r = arr[right];
            if(vowels.contains(l) && vowels.contains(r)){
                char temp = arr[left];
                arr[left] = arr[right] ;
                arr[right] = temp;
                left++;
                right--;
            }else if(!vowels.contains(l)){
                left++;
            }else if(!vowels.contains(r)){
                right--;
            }
        }

        return new String(arr);
    }
}
