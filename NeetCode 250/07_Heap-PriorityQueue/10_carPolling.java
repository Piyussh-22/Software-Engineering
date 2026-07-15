import java.util.*;
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        //sort
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);

        // minHeap sorted by drop distance from least to highest. 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        int currPass = 0;
        for(int[] trip : trips){
            int passengers = trip[0];
            int pick = trip[1];

            // current pick location is at or ahead of some drop location with certain number of pass..
            while(!pq.isEmpty() && pick >= pq.peek()[1]){
                currPass = currPass - pq.poll()[0];
            }
            currPass += passengers;
            if(currPass > capacity){
                return false;
            }
            pq.add(new int[]{trip[0] , trip[2]});
        }
        return true;  
    }
}