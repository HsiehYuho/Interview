package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Find_Target_Number_in_2_BST_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Target_Number_in_2_BST_ sol = new Find_Target_Number_in_2_BST_();
		sol.exe();
		return;
	}
	private void exe() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n7 = new TreeNode(5);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode t11 = new TreeNode(11);
		n5.left = n3;
		n5.right = n7;
		n3.left = n1;
		n3.right = n4;
		t9.left = t5;
		t5.right = t6;
		t9.right = t11;
		t11.left = t10;
		
		int target = 10;
		List<int[]> res = findPairs(n5,t9,target);
		for(int[] i : res) {
			System.out.println(i[0] + " " + i[1]);
		}
		
		return;
	}
	private List<int[]> findPairs(TreeNode root1, TreeNode root2, int target){
		PreItr preItr = new PreItr(root1);
		PostItr postItr = new PostItr(root2);
		List<int[]> res = new ArrayList<>();
		while(preItr.hasNext() && postItr.hasNext()) {
			TreeNode n1 = preItr.top();
			TreeNode n2 = postItr.top();
//			System.out.println(n1.val + " " + n2.val);
			int sum = n1.val + n2.val;
			if(target == sum) {
				res.add(new int[] {n1.val,n2.val});
				preItr.next();
				postItr.next();
			}
			else if (target > sum) {
				preItr.next();
			}
			else {
				postItr.next();
			}
		}
		return res;
		
		
	}
	private class PreItr{
		private Stack<TreeNode> stack = new Stack<>();
		private TreeNode root;
		public PreItr(TreeNode root) {
			this.root = root;
			TreeNode ptr = root;
			while(ptr != null) {
				stack.add(ptr);
				ptr = ptr.left;
			}
		}
		private boolean hasNext() {
			return !stack.isEmpty();
		}
		private TreeNode top() {
			return stack.peek();
		}
		private TreeNode next() {
			TreeNode cur = stack.pop();
			TreeNode ptr = cur.right;
			while(ptr != null) {
				stack.add(ptr);
				ptr = ptr.left;
			}
			return cur;
		}
	}
	private class PostItr{
		private Stack<TreeNode> stack = new Stack<>();
		private TreeNode root;
		public PostItr(TreeNode root) {
			this.root = root;
			TreeNode ptr = root;
			while(ptr != null) {
				stack.add(ptr);
				ptr = ptr.right;
			}
		}
		private TreeNode top() {
			return stack.peek();
		}
		private boolean hasNext() {
			return !stack.isEmpty();
		}
		private TreeNode next() {
			TreeNode cur = stack.pop();
			TreeNode ptr = cur.left;
			while(ptr != null) {
				stack.add(ptr);
				ptr = ptr.right;
			}
			return cur;
		}
	}	
	
	private class TreeNode{
		TreeNode left, right;
		int val;
		public TreeNode(int val) {
			this.val = val;
		}
	}


}
