package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class _501 {
	public static void main(String[] args) {
		_501 a = new _501();
		a.exe();
	}
	public void exe() {
		return;
	}
	int count = 1;
	int max = 0;
	Integer pre = null;
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        int[] res = new int[list.size()];
        int idx = 0;
        for(int i : list) {
        		res[idx++] = i;
        }
        return res;        		
    }
    public void traverse(TreeNode node, List<Integer> list) {
    		if(node == null)
    			return;
    		traverse(node.left,list);
    		if(pre != null) {
    			if(node.val == pre)
    				count++;
    			else {
    				count = 1;
    			}
    		}
    		if(count > max) {
    			max = count;
    			list.clear();
    			list.add(node.val);
    		}
    		else if(count == max) {
    			list.add(node.val);
    		}    		
		pre = node.val;
    		traverse(node.right,list);
    		
    }
    public class TreeNode {
    		int val;
    		TreeNode left;
    		TreeNode right;
    		TreeNode(int x) { val = x; }
    }
}
