package api_design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _432 {
	public static void main(String[] args) {
		return;
	}
	public void exe() {
		AllOne();
		inc("A");
		inc("C");
		inc("A");
		System.out.println(getMaxKey());
		System.out.println(getMinKey());
		return;
	}
	/** Initialize your data structure here. */
	private Bucket head, tail;
	private HashMap<Integer,Bucket> countBucketMap; // store the count -> bucket
	private HashMap<String,Integer> keyCountMap; // store the key -> count
  	public class Bucket{
  		int count; // the set of string
  		Set<String> keySet;
  		Bucket next, pre;
  		public Bucket(int n) {
  			count = n;
  			keySet = new HashSet<>();
  		}	
  	}
	public void AllOne() {
		head = new Bucket(Integer.MIN_VALUE);
		tail = new Bucket(Integer.MAX_VALUE);
		head.next = tail;
		tail.pre = head;
		countBucketMap = new HashMap<>();
		keyCountMap = new HashMap<>();
		
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    		if(keyCountMap.containsKey(key))
    			changeKey(key,1);
    		else {
    			keyCountMap.put(key, 1);
    			if(head.next.count != 1) 
    				addBucketAfter(new Bucket(1),head);
    			head.next.keySet.add(key);
    			countBucketMap.put(1, head.next);
    		}
    }
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
    		if(keyCountMap.containsKey(key)){
    			int count = keyCountMap.get(key);
    			if(count == 1) {
    				keyCountMap.remove(key);
    				removeKeyFromBucket(countBucketMap.get(count),key);
    			}
    			else
    				changeKey(key,-1);
    		}
	}
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
    		return tail.pre == head ? "" : (String) tail.pre.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : (String) head.next.keySet.iterator().next();
    }
    private void changeKey(String key, int offset) {
    		int count = keyCountMap.get(key);
    		keyCountMap.put(key, count+offset);
    		Bucket curBucket = countBucketMap.get(count);
    		Bucket newBucket;
    		if(!countBucketMap.containsKey(count+offset)) {
    			newBucket = new Bucket(count+offset);
    			countBucketMap.put(count+offset, newBucket);
    			addBucketAfter(newBucket,offset == 1 ? curBucket : curBucket.pre);
    		}
    		else {
    			newBucket = countBucketMap.get(count+offset);
    		}
    		newBucket.keySet.add(key);
    		removeKeyFromBucket(curBucket,key);
    }
    private void removeKeyFromBucket(Bucket curBucket, String key) {
    		curBucket.keySet.remove(key);
    		if(curBucket.keySet.size() == 0) {
    			removeBucketFromList(curBucket);
    			countBucketMap.remove(curBucket.count);
    		}
    }
    private void removeBucketFromList(Bucket curBucket) {
    		curBucket.next.pre = curBucket.pre;
    		curBucket.pre.next = curBucket.next;
    		curBucket.pre = null;
    		curBucket.next = null;
    }
    private void addBucketAfter(Bucket newBucket, Bucket curBucket) {
    		Bucket tmp = curBucket.next;
    		curBucket.next = newBucket;
    		newBucket.pre = curBucket;
    		newBucket.next = tmp;
    		tmp.pre = newBucket;
    }

}
