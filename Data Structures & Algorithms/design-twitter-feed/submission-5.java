class Tweet{
    int time;
    int tweetId;

    Tweet(int t,int tID){
        time = t;
        tweetId = tID;
    }

}
class User{
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    User(int id){
        userId = id;
        followers = new HashSet<>();
        followers.add(id);
        tweets = new LinkedList<>();
    }
    public void addPost(Tweet t){
        tweets.add(0,t);
    }
    public void follow(int id){
        followers.add(id);
    }
    public void unFollow(int id){
        followers.remove(id);
    }
    
}
class Twitter {
    int timeCount;
    HashMap<Integer, User> userMap;
     public Twitter() {
        timeCount=0;
        userMap= new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        timeCount++;
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        User user = userMap.get(userId);
        user.addPost(new Tweet(timeCount,tweetId));

    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!userMap.containsKey(userId)){
            return new ArrayList<>();
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> b.time-a.time);
        User user = userMap.get(userId);

        for(int followeeId : user.followers){
            int count=0;
            for(Tweet tweet : userMap.get(followeeId).tweets){
                pq.add(tweet);
                
                count++;
                if(count >= 10){
                    break;
                }
                
            }
        }

        List<Integer> ans = new ArrayList<>();
        
        int count =0;
        while(!pq.isEmpty() && count <10){
            Tweet t = pq.poll();
            ans.add(t.tweetId);
            count++;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new User(followerId));
        }
        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId,new User(followeeId));
        }
        User user = userMap.get(followerId);
        user.follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
            return;
        }
        if(followerId == followeeId){
            return;
        }
        User user = userMap.get(followerId);
        user.unFollow(followeeId);
    }
}
