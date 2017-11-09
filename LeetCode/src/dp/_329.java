package dp;

public class _329 {
	public static void main(String[] args) {
		_329 a = new _329();
		a.exe();
	}
	public void exe() {
		int[][] matrix = new int[][] {{7,7,5},{2,4,6},{8,2,0}};
		System.out.println(longestIncreasingPath(matrix));
		return;
	}
    public int longestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return 0;
    		int m = matrix.length, n = matrix[0].length;
    		int[][] dp = new int[m][n]; // dp[i][j] = from i , j to start the longest way
    		int max = 0;
    		int[][] add = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    		boolean[][] used = new boolean[m][n];
    		for(int i = 0; i < m; i++) {
    			for(int j = 0; j < n; j++) {
    				max = Math.max(max,getMax(matrix,dp,i,j,add,used));
    			}
    		}
    		return max+1;
    		
    }
    private int getMax(int[][] matrix, int[][] dp, int i, int j, int[][] add,boolean[][] used) {
    		if(dp[i][j] != 0)
    			return dp[i][j];
    		int max = 0;
    		for(int k = 0; k < add.length; k++) {
    			int newI = i+add[k][0];
    			int newJ = j+add[k][1];
    			if(newI < 0 || newJ < 0 || newI >= matrix.length || newJ >= matrix[0].length)
    				continue;
    			if(matrix[i][j] < matrix[newI][newJ] && !used[newI][newJ]) {
    				used[newI][newJ] = true;
    				dp[i][j] = Math.max(dp[i][j], 1+getMax(matrix,dp,newI,newJ,add,used));
       			used[newI][newJ] = false;    				
    			}
    			max = Math.max(max,dp[i][j]);
    		}
    		return max;
    }
}
