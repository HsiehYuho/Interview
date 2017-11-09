package queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _314 {
	public static void main(String[] args) {
		_314 a = new _314();
		a.exe();
	}
	public void exe() {
		return;
	}
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null)
			return res;
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();
		nodes.add(root);
		cols.add(0);
		int minId = 0, maxId = 0;
		while(nodes.size() != 0) {
			TreeNode node = nodes.poll();
			int col = cols.poll();
			if(!map.containsKey(col)) {
				map.put(col, new ArrayList<>());
			}
			List<Integer> list = map.get(col);
			list.add(node.val);
			if(node.left != null) {
				nodes.add(node.left);
				cols.add(col-1);
				minId = Math.min(col-1, minId);
			}
			if(node.right != null) {
				nodes.add(node.right);
				cols.add(col+1);
				maxId = Math.max(col+1, maxId);
			}		
		}
		for(int i = minId; i <= maxId; i++) {
			res.add(map.get(i));
		}
		return res;	
    }
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
