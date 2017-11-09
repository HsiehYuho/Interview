package dp;

public class _576 {
	public static void main(String[] args) {
		_576 a = new _576();
		a.exe();
	}
	public void exe() {
		System.out.println(findPaths(1,3,3,0,1));
		return;
	}
	public int findPaths(int m, int n, int N, int i, int j) {
		int[][][] dp = new int[m][n][N+1];
		for(int k = 1; k <= N; k++) {
			for(int x = 0; x < m; x++) {
				for(int y = 0; y < n; y++) {
					if(x == 0)
						dp[x][y][k]++;
					if(y == 0)
						dp[x][y][k]++;
					if(x == m-1)
						dp[x][y][k]++;
					if(y == n-1)
						dp[x][y][k]++;
					if(x > 0)
						dp[x][y][k] += dp[x-1][y][k-1]; // when it goes up, how close it is away from out of boundary
					if(x < m-1)
						dp[x][y][k] += dp[x+1][y][k-1]; // goes down
					if(y > 0)
						dp[x][y][k] += dp[x][y-1][k-1]; // goes left
					if(y < n-1)
						dp[x][y][k] += dp[x][y+1][k-1]; // goes right
					dp[x][y][k] %= 1000000007; 
				}
			}
		}
		return dp[i][j][N] ;
    }
}
