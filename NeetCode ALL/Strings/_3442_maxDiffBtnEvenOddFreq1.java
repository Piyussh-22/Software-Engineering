class Solution {
    public int maxDifference(String s) {
        int[] freqCount = new int[26];

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            freqCount[c-'a']++;
        }

        int largestOdd = Integer.MIN_VALUE;
        int smallestEven = Integer.MAX_VALUE;

        for(int freq : freqCount){
            if(freq == 0) continue;
            if(freq % 2 == 0){
                smallestEven = Math.min(smallestEven, freq);
            } else {
                largestOdd = Math.max(largestOdd, freq);
            }
        }

        // edge case
        if(largestOdd == Integer.MIN_VALUE || smallestEven == Integer.MAX_VALUE)
            return 0;

        return largestOdd - smallestEven;
    }
}
