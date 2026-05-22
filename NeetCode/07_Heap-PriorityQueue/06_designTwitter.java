import java.util.*;
class Twitter {
    HashMap<Integer, HashSet<Integer>> followMap ;
    HashMap<Integer, ArrayList<int[]>> postMap;
    PriorityQueue<int[]> maxHeap;
    int time = 1;
    public Twitter() {  // constructor
        followMap = new HashMap<>();
        postMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!postMap.containsKey(userId)){
            postMap.put(userId, new ArrayList<int[]>());
        }
        postMap.get(userId).add(new int[]{tweetId,time});
        time++;
    }
    
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> connected = new ArrayList<>();
        if(followMap.containsKey(userId)){
            connected = new ArrayList<>(followMap.get(userId)); // create copy
        }
        connected.add(userId);

        maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int id : connected){
            if(postMap.containsKey(id)){
                for(int[] post : postMap.get(id)){
                    maxHeap.add(post);
                }
            }
        }
        // most recent high time to less time. so max heap/pq
        List<Integer> topTenPost = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            if(maxHeap.isEmpty()) break;
            topTenPost.add(maxHeap.poll()[0]);
        }
        return topTenPost;

    }
    
    public void follow(int followerId, int followeeId) {    
        if(!followMap.containsKey(followerId)){
            followMap.put(followerId, new HashSet<>());
        }
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
       if(followMap.containsKey(followerId)){
        followMap.get(followerId).remove(followeeId);
        // .remove return true/false so no error if not found.
       }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */