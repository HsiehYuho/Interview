package fb;

public class Number_of_Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	// you do not have to do the union found
	// what you should do is to eliminate the whole matrix one by one
    int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
    		if (grid == null || grid.length == 0)
    			return 0;
    		int m = grid.length, n = grid[0].length;
    		int island = 0;
    		for(int i = 0; i < m; i++) {
    			for(int j = 0; j < n; j++) {
    				if(grid[i][j] == '1') {
    					grid[i][j] = '0';
    					dfs(grid,i,j,m,n);
    					island++;    					
    				}
    			}
    		}
    		return island;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n) {
    		for(int d = 0; d < dirs.length; d++) {
    			int x = i+ dirs[d][0], y = j +dirs[d][1];
    			if(x >= m || x < 0 || y >= n || y < 0 || grid[x][y] == '0')
    				continue;
    			grid[x][y] = '0';
    			dfs(grid,x,y,m,n);
    		}
    		return;
    }

}
