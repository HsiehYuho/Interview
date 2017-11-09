package twitter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class GetRecommendedTweets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetRecommendedTweets sol = new GetRecommendedTweets();
		sol.exe();
	}
	private void exe() {
		int[][] followGraph = new int[][] {{1,2},{1,3},{1,4},{2,3},{2,5}};
		int[][] likeGraph = new int[][] {{2,2},{2,2},{4,1},{5,1},{3,2},{3,2}};
		int targetUserId = 1;
		int threshold = 2;
		List<List<Integer>> relationships = new ArrayList<>();
		List<List<Integer>> likeTweets = new ArrayList<>();
		for(int i = 0; i < followGraph.length; i++) {
			int[] rel = followGraph[i];
			List<Integer> tmp = new ArrayList<>();
			for(int u : rel) {
				tmp.add(u);
			}
			relationships.add(tmp);
		}
		for(int i = 0; i < likeGraph.length; i++) {
			int[] like = likeGraph[i];
			List<Integer> tmp = new ArrayList<>();
			for(int t : like) {
				tmp.add(t);				
			}
			likeTweets.add(tmp);
		}
		List<Integer> recommendList = getRecommendedTweets(relationships,likeTweets,targetUserId,threshold);
		for(int tweetId : recommendList)
			System.out.println(tweetId);
		return;
	}
	HashMap<Integer,User> idToUser = new HashMap<>(); 
	HashMap<Integer,Tweet> idToTweet = new HashMap<>();
	private List<Integer> getRecommendedTweets(List<List<Integer>> followGraph_edges, 
												List<List<Integer>> likeGraph_edges, 
												int targetUserId, int minLikeThreshold){
		buildFollowGraph(followGraph_edges);
		buildLikeGraph(likeGraph_edges);
		List<Integer> recommendedTweets = findTweets(targetUserId,minLikeThreshold);
		return recommendedTweets;
	}
	private void buildFollowGraph(List<List<Integer>> followGraph_edges) {
		for(List<Integer> list : followGraph_edges) {
			for(int id : list) {
				if(!idToUser.containsKey(id))
					idToUser.put(id,new User(id));
			}
			User follower = idToUser.get(list.get(0));
			User followee = idToUser.get(list.get(1));
			follower.following.add(followee);
		}
	}
	private void buildLikeGraph(List<List<Integer>>likeGraph_edges) {
		for(List<Integer> list : likeGraph_edges) {
			int userId = list.get(0);
			int tweetId = list.get(1);
			if(!idToTweet.containsKey(list.get(1))){
				idToTweet.put(tweetId, new Tweet(tweetId));
			}
			Tweet tweet = idToTweet.get(tweetId);
			User user = idToUser.get(userId);
			tweet.whoLikes.add(user);
			user.pressLike.add(tweet);
		}
	}
	private List<Integer> findTweets(int targetUserId, int minLikeThreshold){
		User targetUser = idToUser.get(targetUserId);
		HashSet<User> followByTarget = targetUser.following;
		// priorityqueue store int[] {tweetId,count}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){ 
			public int compare(int[] a, int[] b) {
				return b[1] - a[1];							
			}
		});
		HashMap<Tweet,Integer> counterMap = new HashMap<>();
		HashSet<Tweet> unsortedTweet = new HashSet<>();
		for(User u : followByTarget) {
			for(Tweet t : u.pressLike) {
				counterMap.put(t, counterMap.getOrDefault(t,0)+1);
				if(counterMap.get(t) >= minLikeThreshold)
					unsortedTweet.add(t);
			}
		}
		for(Tweet t : unsortedTweet) {
			int count = counterMap.get(t);
			pq.add(new int[] {t.id,count});
		}
		List<Integer> recommendList = new ArrayList<>();
		while(pq.size() != 0) {
			recommendList.add(pq.poll()[0]);
		}
		return recommendList;
	}
	private class User{
		int id;
		HashSet<User> following;
		HashSet<Tweet> pressLike;
		public User(int id) {
			this.id = id;
			following = new HashSet<>();
			pressLike = new HashSet<>();
		}
	}
	private class Tweet{
		int id;
		HashSet<User> whoLikes;
		public Tweet(int id) {
			this.id = id;
			whoLikes = new HashSet<>();
		}
	}
}
