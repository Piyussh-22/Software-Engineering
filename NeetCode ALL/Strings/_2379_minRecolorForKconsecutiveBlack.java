class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOps = Integer.MAX_VALUE;
        for(int i = 0 ; i <= blocks.length()-k ; i++){
            int start = i;
            int end = k-1+i;
            int tempMinOps = 0 ;
            while(start <= end){
                if(blocks.charAt(start) != 'B'){
                    tempMinOps++;
                }
                start++;
            }
            minOps = Math.min(minOps,tempMinOps);
        }
        return minOps;
    }
}

class Solution {
    public int minimumRecolors(String blocks, int k) {

        int currWhite = 0;

        for (int i = 0; i < k; i++){
            if (blocks.charAt(i) == 'W') currWhite++;
        }
        int minWhite = currWhite;

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i - k) == 'W') currWhite--;
            if (blocks.charAt(i) == 'W') currWhite++;
            minWhite = Math.min(minWhite, currWhite);
        }

        return minWhite;
    }
}