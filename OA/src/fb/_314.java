package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _314 {
	public static void main(String[] args) {
		return;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	// interesting - using recursive function will lead to kind of bottom up
	// so I need to use iterative way to solve it
	// a queue, a map and a list 
	public List<List<Integer>> verticalOrder(TreeNode root) {
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		List<List<Integer>> array = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		HashMap<TreeNode, Integer> nodePos = new HashMap<>();
		int min = Integer.MAX_VALUE;
		if(root == null)
			return array;
		q.offer(root);
		nodePos.put(root,0);
		while(q.size()!=0) {
			TreeNode node = q.poll();
			int pos = nodePos.get(node);
			if(!map.containsKey(pos))
				map.put(pos, new ArrayList<Integer>());
			map.get(pos).add(node.val);
			if(node.left != null) {
				q.offer(node.left);
				nodePos.put(node.left, pos-1);
			}
			if(node.right != null) {
				q.offer(node.right);
				nodePos.put(node.right, pos+1);
			}
			min = Math.min(min, pos);	
		}
		while(map.containsKey(min)) {
			array.add(map.get(min++));
		}
		return array;

		
	}
}
