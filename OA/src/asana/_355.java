package asana;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class _355 {
	public static void main(String[] args) {
		
	}
	// important part, linked the everyone's tweet 
	// so that when getNewsFeed will increase efficiency
	// need the design of tweet, user, timeStamp
	
	int timeStamp = 0;
	
	public class Tweet{
		int time;
		int id;
		Tweet next;
		public Tweet(int id) {
			this.id = id;
			time = timeStamp++;
			next = null;
		}
	}
	
	public class User{
		int id;
		HashSet<Integer> follow;
		Tweet head;
		public User(int id) {
			this.id = id;
			head = null;
			follow = new HashSet<>();
			follow(id);
		}
		public void follow(int followeeId) {
			follow.add(followeeId);
		}
		public void unfollow(int followeeId) {
			follow.remove(followeeId);
		}
		public void post(int tweetId) {
			Tweet tmp = head;
			head = new Tweet(tweetId);
			head.next = tmp;
		}
		
	}
	HashMap<Integer, User> map; // record userId map to user
	
	/** Initialize your data structure here. */
    public void Twitter() {
    		map = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId))
        		map.put(userId, new User(userId));
        User u = map.get(userId);
        u.post(tweetId);
    }
    
    // Best part of this.
    // first get all tweets lists from one user including itself and all people it followed.
    // Second add all heads into a max heap. Every time we poll a tweet with 
    // largest time stamp from the heap, then we add its next tweet into the heap.
    // So after adding all heads we only need to add 9 tweets at most into this 
    // heap before we get the 10 most recent tweet.

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    		List<Integer> res=  new ArrayList<>();
    		if(!map.containsKey(userId))
    			return res;
    		User user = map.get(userId);
    		PriorityQueue<Tweet> q = new PriorityQueue<>(user.follow.size(),new Comparator<Tweet>(){
    			public int compare(Tweet a, Tweet b) {
    				return b.time - a.time;
    			}
    		});
    		for(int i : user.follow) {
    			User u = map.get(i);
    			if(u.head != null)
    				q.add(u.head);
    		}
    		int n = 0;
    		while(q.size() != 0 && n < 10) {
    			Tweet t = q.poll();
    			res.add(t.id);
    			if(t.next != null)
    				q.add(t.next);
    			n++;
    		}
    		return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId))
        		map.put(followerId, new User(followerId));
        if(! map.containsKey(followeeId))
        		map.put(followeeId, new User(followeeId));
		User u = map.get(followerId);
		u.follow(followeeId);
		return;
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!map.containsKey(followerId) || ! map.containsKey(followeeId))
			return;
        User u = map.get(followerId);
		u.unfollow(followeeId);
   }
}
