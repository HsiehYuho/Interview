package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Validate_BT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Validate_BT sol = new Validate_BT();
		sol.exe();
	}
	private void exe() {
		List<TreeNode> nodes = new ArrayList<>();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n3;
		nodes.add(n1);
		nodes.add(n2);
		nodes.add(n3);
		nodes.add(n4);
		nodes.add(n5);
		System.out.println(isValidBt(nodes));
		return;
	}
	// first there must no be cycle
	// every node must be inside the list
	// only one root and the other is only the intermediate node
	private boolean isValidBt(List<TreeNode> nodes) {
		HashMap<TreeNode,Integer> map = new HashMap<>(); 
		for(TreeNode node : nodes) {	
			map.put(node, 0);
		}
		for(TreeNode node: nodes) {
			if(node.left != null) {
				if(!map.containsKey(node.left))
					return false;
				else
					map.put(node.left, map.get(node.left)+1);
			}
			if(node.right != null) {
				if(!map.containsKey(node.right))
					return false;
				else
					map.put(node.right, map.get(node.right)+1);
			}
		}
		boolean findRoot = false;
		for(TreeNode node : map.keySet()) {
			if(map.get(node) == 0) {
				if(findRoot)
					return false;
				findRoot = true;				
			}
			else if(map.get(node) != 1)
				return false;
		}
		return map.keySet().size() == nodes.size();
	}
	private class TreeNode{
		TreeNode left, right;
		int val;
		public TreeNode(int val) {
			this.val = val;
		}
	}

}
