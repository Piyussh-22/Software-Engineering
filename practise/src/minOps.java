public class minOps {
    public static void main(String[] args){
        System.out.println(minimumRecolors("BWBBWWBBBWBWWWBWWBBWBWBBWBB",11));
    }
    static int minimumRecolors(String blocks, int k) {
        //first window
        int whiteCount = 0;
        for(int i = 0 ; i < k ; i++){
            if(blocks.charAt(i) == 'W'){
                whiteCount++;
                System.out.println("white added for i "+i);
            }
        }

        System.out.println("firstwhitecount "+ whiteCount);
        if(blocks.length() == k) return whiteCount;

        for(int i = 1 ; i <= blocks.length()-k ; i++){
            int tempWhiteCount = whiteCount;
            int start = i;
            int end = k-1+i;
            if(blocks.charAt(start-1) == 'W'){
                tempWhiteCount--;
            }
            if(blocks.charAt(end) == 'W'){
                tempWhiteCount++;
            }
            if(tempWhiteCount == 0) return 0;
            System.out.println("tempwhite for i "+i+" is "+tempWhiteCount);
            whiteCount = Math.min(tempWhiteCount,whiteCount);
            System.out.println("min white count after i " +i+ " is "+whiteCount );
        }
        return whiteCount;
    }
}
