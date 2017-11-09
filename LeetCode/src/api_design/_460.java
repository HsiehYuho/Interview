package api_design;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class _460 {
	public static void main(String[] args) {
		_460  a = new _460();
		a.exe();
		return;
	}
	public void exe() {
		LFUCache lfu = new LFUCache(3);
		lfu.put(2, 2);
		lfu.put(1, 1);
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(2));
		lfu.put(3, 3);
		lfu.put(4, 4);
		System.out.println(lfu.get(3));
		System.out.println(lfu.get(2));
		System.out.println(lfu.get(1));
		System.out.println(lfu.get(4));
		return;
	}
	public class LFUCache {
		private Node head = null;
		private int cap = 0;
		private HashMap<Integer,Integer> valueHash;
		private HashMap<Integer,Node> nodeHash;
		public LFUCache(int capacity) {
			this.cap = capacity;;
			valueHash = new HashMap<>();
			nodeHash = new HashMap<>();
		}
		public int get(int key) {
			if(valueHash.containsKey(key)) {
				increaseCount(key);
				return valueHash.get(key);
			}
			return -1;
		}
		public void put(int key, int value) {
			if(cap == 0)
				return;
			if(valueHash.containsKey(key))
					valueHash.put(key, value);
			else {
				if(valueHash.size() < cap) {
					valueHash.put(key, value);
				}
				else {
					removeOld();
					valueHash.put(key, value);
				}
				addToHead(key);
			}
			increaseCount(key);
		}
		private void increaseCount(int key) {
			Node node = nodeHash.get(key);
			node.keys.remove(key);
			if(node.next == null) {
				node.next = new Node(node.count+1);
				node.next.pre = node;
				node.next.keys.add(key);
			}
			else if (node.next.count == node.count+1)
				node.next.keys.add(key);
			else {
				Node tmp = new Node(node.count+1);
				tmp.keys.add(key);
				tmp.pre  = node;
				tmp.next = node.next;
				node.next.pre = tmp;
				node.next = tmp;
			}
			nodeHash.put(key, node.next);
			if(node.keys.size() == 0)
				remove(node);
		}
		private void addToHead(int key) {
			if(head == null) {
				head = new Node(0);
				head.keys.add(key);
			}
			else if(head.count > 0) {
				Node node = new Node(0);
				node.keys.add(key);
				node.next = head;
				head.pre = node;
				head = node;
			}
			else {
				head.keys.add(key);
			}
			nodeHash.put(key,head);
			
		}
		private void remove(Node node) {
			if(node.pre == null)
				head = node.next;
			else
				node.pre.next = node.next;
			if(node.next != null)
				node.next.pre = node.pre;
		}
		private void removeOld() {
			if(head == null)
				return;
			int old = head.keys.iterator().next();
			head.keys.remove(old);
			if(head.keys.size() == 0)
				remove(head);
			nodeHash.remove(old);
			valueHash.remove(old);
		}
		class Node{
			public int count;
			public LinkedHashSet<Integer> keys = null;
			public Node pre, next;
			public Node(int count) {
				this.count = count;
				keys = new LinkedHashSet<>();
				pre = next = null;
			}
		}
		
	}
	
	
}
