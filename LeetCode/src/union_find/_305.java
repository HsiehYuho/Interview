package union_find;

import java.util.ArrayList;
import java.util.List;

public class _305 {
	public static void main(String[] args) {
		_305 a = new _305();
		a.exe();
	}
	public void exe() {
		return;
	}
	private final int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> list = new ArrayList<>();
		union2D u = new union2D(m,n);
		for(int[] pos : positions) {
			int x = pos[0], y = pos[1];
			int p = u.add(x, y); // p = cur island
			for(int[] dir : dirs) {
				int q = u.getID(x+dir[0],y+dir[1]);
				if(q != 0 && !u.find(p, q))
					u.union(p, q);
			}
			list.add(u.getSize());
		}
		return list;
    }
	private class union2D {
		int[] ids,sz;
		int m,n,count;
		public union2D(int m, int n) {
			this.m = m;
			this.n = n;
			ids = new int[m*n+1];
			sz = new int[m*n+1];
			count = 0;
		}
		public int getIndex(int x, int y) {
			return x * n + y + 1;
		}
		public int getID(int x, int y) {
			if(x >= 0 && x < m && y >= 0 && y < n)
				return ids[getIndex(x,y)];
			return 0;
		}
		public int getSize() {
			return count;
		}
		public int add(int x, int y) {
			int i = getIndex(x,y);
			ids[i] = i;
			sz[i] = 1;
			count++;
			return i;
		}
		public boolean find(int i, int j) {
			return root(i) == root(j); 
		}
		public void union(int i, int j) {
			int p = root(i);
			int q = root(j);
			// weighted quick union
			if(sz[p] > sz[q]) {
				ids[q] = p;
				sz[p] += sz[q];
			}
			else {
				ids[p] = q;
				sz[q] += sz[p];
			}
			count--;
		}
		public int root(int i) {
			while(i != ids[i]) {
				ids[i] = ids[ids[i]]; // path compression
				i = ids[i];
			}
			return i;
		}
	}
}
