import java.util.*;
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder sb = new StringBuilder();

        // maxHeap 
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q) -> q[1] - p[1]);
        
        //ascii,count     char/'a' gets converted to ascii
        if(a > 0) pq.add(new int[]{'a',a}); 
        if(b > 0) pq.add(new int[]{'b',b});
        if(c > 0) pq.add(new int[]{'c',c});

        while(!pq.isEmpty()){

            int[] first = pq.poll();
            int n = sb.length();

            // can make aaa.
            if(n >= 2 && sb.charAt(n-1) == (char) first[0] && sb.charAt(n-2) == (char) first[0]){
                if(!pq.isEmpty()){
                    int[] second = pq.poll();
                    sb.append((char) second[0]);
                    second[1]--;
                    if(second[1] > 0){
                        pq.add(second);
                    }
                    pq.add(first);
                }
            }else{
                sb.append((char)first[0]);
                first[1]--;
                if(first[1] > 0){
                    pq.add(first);
                }
            }
        }
        return sb.toString();
    }
}