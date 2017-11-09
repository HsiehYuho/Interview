package dp;

public class _629 {
	public static void main(String[] args) {
		_629 a = new _629();
		a.exe();
	}
	public void exe() {
		System.out.println(kInversePairs(35,4));
		return;
	}
	public int kInversePairs(int n, int k) {
/*		int[][] dp = new int[n+1][k+1]; // dp[i][j] means from 1 to i, has j pairs reverse
		int mod = 1000000007;
		//initialize
		dp[1][0] = 1; // dp[1][0] = from 1 to 1 with no reverse pairs, only 1 kind 
		// transition function
		// dp[i+1][j] = dp[i][j] + dp[i][j-1] + dp[i][j-2] + ...dp[i][j-i]
		// dp[i][j] = put N+1 at last, dp[i][j-1] = put N+1 at second last position...
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < k+1; j++) {
				int tmpI = 0;
				while((j - tmpI)>= 0 && tmpI <= i) {  // at most can we put n+1 number at k-n position
					dp[i+1][j] += (dp[i][j-tmpI]);
					dp[i+1][j] %= mod;
					tmpI++;
				}
			}
		}
		return dp[n][k];
		*/
		 /**
         * inverse[n+1][k] = inverse[n][k] + inverse[n][k-1] + ... + inverse[n][k-n]
         * inverse[n+1][k-1] =               inverse[n][k-1] + ... + inverse[n][k-n] + inverse[n][k-n-1]
         *
         * so inverse[n+1][k] = inverse[n+1][k-1] + inverse[n][k] - inverse[n][k-n-1];
         *
         * so inversen[n][k] = inverse[n][k-1] + inverse[n-1][k] + inverse[n-1][k-n];
         *
         **/
		int[][] dp = new int[2][k+1];
		int mod = 1000000007;
		dp[0][0] = 1;
		for(int i = 1; i <= n; i++) {
			dp[1][0]  = 1;// [n=1][k=0]
			for(int j = 1; j <= k; j++) {
				dp[1][j] = dp[1][j-1] + dp[0][j];
				if(j-i >= 0) {
					dp[1][j] += mod - dp[0][j-i];
				}
				dp[1][j] %= mod;
			}
			int[] tmp = dp[0];
			dp[0] = dp[1];
			dp[1] = tmp;
		}
		return dp[0][k];
    }
}
