class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //max heap [distance,x,y];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int[] arr : points){
            int distance = arr[0]*arr[0] + arr[1]*arr[1];
            if(pq.size() == k){
                if(pq.peek()[0] > distance){
                    pq.poll();
                    pq.add(new int[]{distance,arr[0],arr[1]});
                }
            }else{
                pq.add(new int[]{distance,arr[0],arr[1]});
            }
        }
        int[][] result = new int[k][2];
        int i = 0;
        //while (!pq.isEmpty())
        for (int[] arr : pq) {
            result[i][0] = arr[1];
            result[i][1] = arr[2];
            i++;
        }
        return result;
    }
}