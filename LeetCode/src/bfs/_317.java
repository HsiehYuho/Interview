package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class _317 {
	public static void main(String[] args) {
		_317 a = new _317();
		a.exe();
	}
	public void exe() {
		System.out.println("test");
		return;
	}
	private final int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    public int shortestDistance(int[][] grid) {
    		if(grid == null || grid.length == 0)
    			return 0;
    		int m = grid.length, n = grid[0].length;
    		int[][] reach = new int[m][n]; // how many buildings can this spot reach?
    		int[][] dis = new int[m][n]; //the distance sum from current spot to every other building
    		Queue<Move> queue = new LinkedList<>();
    		int totalBuilding = 0;
    		int minDis = Integer.MAX_VALUE;
    		for(int i = 0; i < m; i++) {
    			for(int j = 0; j < n; j++) {
    				if(grid[i][j] == 1) {
    					Move mv = new Move(i,j,0);
    					mv.visited = new boolean[m][n];
    					mv.visited[i][j] = true;
    					queue.offer(mv);
    					totalBuilding++;
    				}
    			}
    		}
    		while(!queue.isEmpty()) {
    			Move mv = queue.poll();
    			for(int i = 0; i < 4; i++) {
    				int[] dir = dirs[i];
    				int p = mv.x+dir[0], q = mv.y+dir[1];
    				if(p >= 0 && p < m && q >= 0 && q < n) {
    					if(!mv.visited[p][q] && grid[p][q] == 0) {
    						Move newMv = new Move(p,q,mv.steps+1);
    						newMv.visited = mv.visited;
    						newMv.visited[p][q] = true;
    						dis[p][q] += newMv.steps;
    						reach[p][q]++;
    						if(reach[p][q] == totalBuilding)
    							minDis = Math.min(dis[p][q], minDis);
    						queue.offer(newMv);
    					}
    				}
    			}
    		}
    		return minDis == Integer.MAX_VALUE ? -1 : minDis;
    
    
    
    }
    private class Move{
    		int x, y, steps;
    		boolean[][] visited;
    		public Move(int x, int y, int steps) {
    			this.x = x;
    			this.y = y;
    			this.steps = steps;
    		}
    }
}
