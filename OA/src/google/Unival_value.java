package google;

import java.util.LinkedList;
import java.util.Queue;

public class Unival_value {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Unival_value sol = new Unival_value();
		sol.exe();
	}
	private void exe() {
		int[] A = new int[] {2,2,2,3,2,2,4};
		int[] E = new int[] {0,1,4,0,1,2,1,3,6,4,4,5};
		System.out.println(findPath(A,E));
		return;
	}
	private int findPath(int[] A, int[] E) {
		if(A.length == 0)
			return 0;
		Node[] nodes = new Node[A.length];
		for(int i = 0; i < A.length; i++) {
			nodes[i] = new Node(A[i]);
		}
		for(int i = 0; i < E.length; i+=2) {
			int idx1 = E[i];
			int idx2 = E[i+1];
			nodes[idx1].neighbors.add(nodes[idx2]);
			nodes[idx2].neighbors.add(nodes[idx1]);
		}
		int[] max = new int[] {0};
		Node root = nodes[0];
		recursive(root,max);
		return max[0];
	}
	private int recursive(Node node, int[] max) {
		if(node.neighbors.size() == 0)
			return 0;
		Queue<Node> neighbors = node.neighbors;
		int cur = 0;
		for(Node n : neighbors) {
			n.neighbors.remove(node);
			int tmp = recursive(n,max);
			if(n.val == node.val)
				cur += tmp+1;
		}
		max[0] = Math.max(cur, max[0]);
		return cur;		
	}
	
	private class Node{
		Queue<Node> neighbors;
		int val;
		private Node(int val) {
			this.val = val;
			neighbors = new LinkedList<>();
		}
	}

}
