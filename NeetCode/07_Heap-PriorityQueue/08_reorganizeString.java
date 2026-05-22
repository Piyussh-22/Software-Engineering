import java.util.*;
class Solution {
    public String reorganizeString(String s) {
      // freq map of characters of s.
      Map<Character,Integer> freq = new HashMap<>();
      for(int i = 0 ; i < s.length() ; i++){
        freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i) , 0) + 1);
      }

      // maxHeap highest freq to lowest.
      PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
      for(Character c : freq.keySet()){
        pq.add(new int[]{c,freq.get(c)}); //ASCII,freq
      }

      StringBuilder answer = new StringBuilder();

      int[] prev = null;
      while(!pq.isEmpty()){
        int[] temp = pq.poll();
        answer.append((char)temp[0]);
        temp[1]--;
        if(prev != null && prev[1] > 0){
            pq.add(prev);
        }
        prev = temp;
      }

      if(answer.length() != s.length()){
        return "";
      }

      return answer.toString();
    }
}