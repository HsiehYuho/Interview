package dp;

public class _312 {
	public static void main(String[] args) {
		_312 a = new _312();
		a.exe();
	}
	public void exe() {
		System.out.println(maxCoins(new int[] {3, 1, 5, 8}));
		return;
	}
    public int maxCoins(int[] nums) {
    		int n = nums.length;
    		int[] iNums = new int[n+2];
    		for(int i = 0; i < nums.length; i++) {
    			iNums[i+1] = nums[i];
    		}
    		iNums[0] = iNums[n+1] = 1;
    		int[][] dp = new int[n+2][n+2];
    		for(int k = 2; k < n+2; k++) { // the length of left ~ right
     		for(int left = 0; left < (n+2 - k); left++) {
     			int right = left + k;
     			for(int i = left+1; i < right; i++) {
     				dp[left][right] = Math.max(dp[left][right], 
     					iNums[left]*iNums[i]*iNums[right] + dp[left][i]+dp[i][right]);
     			}
     		}
    		}
    		return dp[0][n+1];
    }
}
