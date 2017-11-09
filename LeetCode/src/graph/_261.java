package graph;

import java.util.HashSet;
public class _261 {
	public static void main(String[] args) {
		_261 a = new _261();
		a.exe();
	}
	public void exe() {
		int[][] edges = new int[][] {{0, 1},{1, 2},{1, 3},{1,4}};
		System.out.println(validTree(5,edges));
//		System.out.println("test");
		return;
	}
    public boolean validTree(int n, int[][] edges) {
    		Node[] nodes = new Node[n];
    		for(int i = 0; i < n; i++) {
    			nodes[i] = new Node(i);
    		}
    		for(int[] edge : edges) {
    			nodes[edge[0]].adj.add(nodes[edge[1]]);
    			nodes[edge[1]].adj.add(nodes[edge[0]]);
    		}
    		HashSet<Node> visit = new HashSet<>();
    		visit.add(nodes[0]);
    		if(!checkValid(nodes[0],null,visit)) {
    			return false;
    		}    			
    		if(visit.size() != n) {
    			return false;    			
    		}
    		return true;		
    }
    private boolean checkValid(Node cur, Node pre, HashSet<Node> visit) {
/*    		if(cur != null)
    			System.out.print(cur.val);
    		if(pre != null)
    			System.out.print(" " +pre.val);
    		System.out.println();*/
    		for(Node next : cur.adj) {
    			if(pre != null && next.val == pre.val) {
    				continue;
    			}
    			if(visit.contains(next)) {
    				return false;    				
    			}
    			visit.add(next);
    			if(!checkValid(next,cur,visit)) {
    				return false;    				
    			}
    		}	
    		return true;	
    }
    private class Node{
    		HashSet<Node> adj;
    		int val;
    		public Node(int val) {
    			this.val = val;
    			adj = new HashSet<>();
    		}
    }
}
