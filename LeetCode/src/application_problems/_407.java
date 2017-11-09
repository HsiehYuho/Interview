package application_problems;

import java.util.PriorityQueue;

public class _407 {
	public static void main(String[] args) {
		_407 a = new _407();
		a.exe();
	}
	public void exe() {
		int[][] map = new int[][] {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
		System.out.println(trapRainWater(map));
		return;
	}
    public int trapRainWater(int[][] heightMap) {
    	if(heightMap == null || heightMap.length == 0 )
            return 0;
    	PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> (a.height - b.height));
    		int m = heightMap.length;
    		int n = heightMap[0].length;
    		boolean[][] visit = new boolean[m][n];
    		int res = 0;
    		for(int i = 0; i < m; i++) {
    			for(int j = 0; j < n; j++) {
    				if(i == 0 ||  j == 0 || i == m-1 || j == n-1) {
    					pq.offer(new Point(heightMap[i][j],i,j));
    	    				visit[i][j] = true;
    				}
    			}
    		}
    		int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    		int localMaxHeight = Integer.MIN_VALUE;
    		while(pq.size() > 0) {
    			Point point = pq.poll();
    			int x = point.x;
    			int y = point.y;
    			int h = point.height;
    			localMaxHeight = Math.max(localMaxHeight, h);
    			for(int i = 0; i < dirs.length; i++) {
    				int neighborX = x + dirs[i][0];
    				int neighborY = y + dirs[i][1];
    				if(neighborX < 0 || neighborX >= m || neighborY < 0 || neighborY >= n || visit[neighborX][neighborY])
    					continue;
    				if(heightMap[neighborX][neighborY] < localMaxHeight) {
    					res += localMaxHeight - heightMap[neighborX][neighborY];
    				}
    				visit[neighborX][neighborY] = true;
    				pq.offer(new Point(heightMap[neighborX][neighborY],neighborX,neighborY));
    			}
    		}
    		return res;
    }
    private class Point{
    		int height;
    		int x;
    		int y;
    		public Point(int height, int x, int y) {
    			this.height = height;
    			this.x = x;
    			this.y = y;
    		}
    }
}

