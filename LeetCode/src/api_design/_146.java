package api_design;

import java.util.HashMap;

public class _146 {
	public static void main(String[] args) {
		_146 a = new _146();
		a.exe();
	}
	public void exe() {
		LFUCache lfu = new LFUCache(0);
		lfu.put(1,1);
		lfu.put(2,2);
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(2));
		return;
	}
	public class LFUCache {
		HashMap<Integer,Node> keyNodeMap; // store key -> node
		Node head, tail; // dummy node
		int size;
		int curSize;
	    public LFUCache(int capacity) {
	        size = capacity;
	        curSize = 0;
	        keyNodeMap = new HashMap<>();
	        head = new Node(Integer.MAX_VALUE,Integer.MAX_VALUE);
	        tail = new Node(Integer.MIN_VALUE,Integer.MIN_VALUE);
	        head.next = tail;
	        tail.pre = head;
	    }
	    
	    public int get(int key) {
	    		if(!keyNodeMap.containsKey(key))
	    			return -1;
	    		else {
	    			Node tmpNode = keyNodeMap.get(key);
	    			keyNodeMap.remove(key);
	    			addAfterHead(removeNode(tmpNode));
	    			keyNodeMap.put(key, tmpNode);
	    			return tmpNode.val;
	    		}
	    }
	    public void put(int key, int value) {
	    		if(size == 0)
	    			return;
	    		if(curSize == size) {
	    			Node tmpNode = removeNode(tail.pre);
	    			keyNodeMap.remove(tmpNode.key);
	    			curSize--;
	    		}
	    		curSize++;
	    		if(keyNodeMap.containsKey(key)) {
	    			Node keyNode = keyNodeMap.get(key);
	    			keyNode.val = value;
	    			addAfterHead(removeNode(keyNode));
	    		}
	    		else {
	    			Node newNode = new Node(key,value);
	    			keyNodeMap.put(key, newNode);
	    			addAfterHead(newNode);
	    		}
	    }
	    private Node removeNode(Node removeNode) {
	    		Node pre = removeNode.pre;
	    		Node next = removeNode.next;
	    		pre.next = next;
	    		next.pre = pre;
	    		removeNode.pre = null;
	    		removeNode.next = null;	    	
	    		return removeNode;
	    }
	    private void addAfterHead(Node addNode) {
	    		Node tmpNext = head.next;
	    		head.next = addNode;
	    		addNode.next = tmpNext;
	    		tmpNext.pre = addNode;
	    		addNode.pre = head;
	    }
	    public class Node{
	    		Node next, pre;
	    		int key,val;
	    		public Node(int k, int v) {
	    			key = k;
	    			val = v;
	    		}
	    }
	}
}
