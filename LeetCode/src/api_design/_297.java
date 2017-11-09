package api_design;

import java.util.LinkedList;
import java.util.Queue;

public class _297 {
	public static void main(String[] args) {
		_297 a = new _297();
		a.exe();
	}
	public void exe() {
		TreeNode root = deserialize("1,2,3,null,null,4,5");
		System.out.println(serialize(root));
		return;
	}

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    		Queue<TreeNode> parent = new LinkedList<>();
    		StringBuilder s = new StringBuilder();
    		if(root != null)
    			parent.offer(root);
    		while(parent.size() != 0) {
    			TreeNode node = parent.poll();
    			if(node != null) {
    				s.append(node.val+",");
        			parent.offer(node.left);        				
        			parent.offer(node.right);    				
    			}
    			else 
    				s.append("null,");
    		}
    		return s.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    		Queue<TreeNode> q = new LinkedList<>();
    		String[] sr = data.split(",");
    		if(sr.length == 0)
    			return null;
    		for(String s : sr) {
    			TreeNode node = null;
    			if(!s.equals("null")&& !s.equals("")){
    				node = new TreeNode(Integer.parseInt(s));
    			}
    			q.add(node);
    		}
    		TreeNode root = null;
    		Queue<TreeNode> parent = new LinkedList<>();
    		if(q.size() != 0) {
    			root = q.poll();    			
    		}
    		if(root != null)
    			parent.add(root);
    		TreeNode ptr =  null;
    		while(q.size()!=0) {
    			ptr = parent.poll();
    			ptr.left = q.poll();
    			ptr.right = q.poll();
    			if(ptr.left != null)
    				parent.add(ptr.left);
    			if(ptr.right != null)
    				parent.add(ptr.right);
    		}
    		return root;        		
    }

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
}
