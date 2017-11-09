package union_find;

public class _323 {
	public static void main(String[] args) {
		_323 a = new _323();
		a.exe();
	}
	public void exe() {
		return;
	}
    public int countComponents(int n, int[][] edges) {
        Union u = new Union(n);
        for(int i = 0; i < n; i++)
        		u.add(i);
        for(int[] edge :edges) {
        		u.union(edge[0], edge[1]);
        }
        return u.count;
    }
    private class Union{
    		int[] parent;
    		int[] size;
    		int count;
    		public Union(int n) {
    			parent = new int[n];
    			size = new int[n];
    			count = 0;
    		}
    		public void add(int x) {
    			parent[x] = x;
    			size[x] = 1;
    			count++;
    		}
    		public int root(int x) {
    			while(parent[x] != x) {
    				parent[x] = parent[parent[x]]; // path compression
    				x = parent[x];
    			}
    			return x;
    		}
    		public void union(int x, int y) {
    			int rootx = root(x);
    			int rooty = root(y);
    			if(rootx != rooty) {
        			if(size[rootx] > size[rooty]) {
        				parent[rooty] = rootx;
        				size[rootx] += size[rooty];
        			}
        			else {
        				parent[rootx] = rooty;
        				size[rooty] += size[rootx];
        			}    	
        			count--;
    			}
    			return;
    		}
    		
    }
}
