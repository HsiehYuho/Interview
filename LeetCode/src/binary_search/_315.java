package binary_search;

import java.util.ArrayList;
import java.util.List;

public class _315 {
	public static void main(String[] args) {
		_315 a = new _315();
		a.exe();
	}
	public void exe() {
		List<Integer> list = countSmaller(new int[] {1,2});
		for(int i : list)
			System.out.print(i + " ");
		return;
	}
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> res = new ArrayList<>();
		if(nums.length == 0)
			return res;
        int ptr = nums.length - 1;
        Node root = new Node(nums[ptr],0,1);
        res.add(0,0);
        ptr--;
        while(ptr >= 0) {
        		insert(nums[ptr],root,0,res);
        		ptr--;
        }
        return res;
    }
	private Node insert(int num, Node root, int sum, List<Integer> res) {
		if(root == null) {
			res.add(0,sum);
			return new Node(num,0,1);
		}
		if(num == root.val) {
			root.dul++;
			res.add(0,root.count+sum);
			return root;
		}
		else if (num < root.val) {
			root.count++;
			if(root.left == null) {
				root.left = insert(num,root.left,sum,res);
			}
			else {
				insert(num,root.left,sum,res);
			}
		}
		else {
			if(root.right == null) {
				root.right = insert(num,root.right, sum + root.count + root.dul,res);
			}
			else {
				insert(num,root.right, sum + + root.count + root.dul,res);
			}
		}
		return root;
	
	}
	private class Node{
		int count;
		int dul;
		int val;
		Node left = null,right = null;
		public Node(int val, int count, int dul) {
			this.val = val;
			this.count = count;
			this.dul =dul;
		}
	}
}
