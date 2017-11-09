package queue;

import java.util.Queue;
import java.util.LinkedList;

public class _286 {
	public static void main(String[] args) {
		_286 a = new _286();
		a.exe();
	}
	public void exe() {
		return;
	}
	private final int INF = 2147483647;
	private final int[][] dir = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    public void wallsAndGates(int[][] rooms) {
    		if(rooms == null || rooms.length == 0)
    			return;
    		Queue<int[]> q = new LinkedList<>();
    		int m = rooms.length, n = rooms[0].length;
    		for(int i = 0 ; i < m; i++) {
    			for(int j = 0; j < n; j++) {
    				if(rooms[i][j] == 0)
    					q.offer(new int[] {i,j});
    			}
    		}
    		int count = 1;
    		while(q.size() != 0) {
    			int size = q.size();
    			for(int i = 0; i < size; i++) {
    				int[] idx = q.poll();
    				for(int d = 0; d < 4; d++) {
    					int x = idx[0]+dir[d][0];
    					int y = idx[1]+dir[d][1];
    					if(x < 0 || x >= m || y < 0 || y >= n)
    						continue;
    					if(rooms[x][y] == INF) {
    						rooms[x][y] = count;
    						q.add(new int[] {x,y});
    					}
    				}
    			}
    			count++;
    		}
        return;
    }	
}
