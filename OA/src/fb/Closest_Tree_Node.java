package fb;

import java.util.LinkedList;
import java.util.Queue;


public class Closest_Tree_Node {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Closest_Tree_Node sol = new Closest_Tree_Node();
		sol.exe();
	}
	private void exe() {
		//          root
		//       1      2
		//     3   4  5   6
		//   7
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		root.left = node1;
		root.right =node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node3.left =node7;
		System.out.println(find(root,node5,node6));

		return;
	}
	private int find(TreeNode root, TreeNode node1, TreeNode node2) {
		TreeNode lca = findLCA(root,node1,node2);
		return findLength(lca,node1,node2);
		
		
	}
	private int findLength(TreeNode root, TreeNode node1, TreeNode node2) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = -1;
		int dis1 = 0, dis2 = 0;
		while(q.size() != 0) {
			level++;
			int count = q.size();
			for(int i = 0; i < count; i++) {
				TreeNode cur = q.remove();
				if(cur.val == node1.val)
					dis1 = level;
				if(cur.val == node2.val)
					dis2 = level;
				if(cur.left != null)
					q.add(cur.left);
				if(cur.right != null)
					q.add(cur.right);
				if(dis1 != 0 && dis2 != 0)
					return dis1+dis2;				
			}
		}
		return -1;
	}
	private TreeNode findLCA(TreeNode root, TreeNode node1, TreeNode node2) {
		if(root == null)
			return null;
		if(root.val == node1.val || root.val == node2.val)
			return root;
		TreeNode left = findLCA(root.left,node1,node2);
		TreeNode right = findLCA(root.right,node1,node2);
		if(left != null && right != null)
			return root;
		else if (left != null)
			return left;
		else if (right != null)
			return right;
		else
			return null;
	}
	
	private class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}

}
