package dp;

public class _546 {
	public static void main(String[] args) {
		_546 a = new _546();
		a.exe();
	}
	public void exe() {
		System.out.println(removeBoxes(new int[] {1, 3, 2, 2, 2, 3, 4, 3, 1}));
		return;
	}
	public int removeBoxes(int[] boxes) {
		int n = boxes.length;
		int[][][] dp = new int[n][n][n]; // dp[i][j][k] means from i to j, there are how many k at left
		return topBottom(dp,0,n-1,0,boxes);
	}
	private int topBottom(int[][][] dp, int i ,int j ,int k, int[] boxes) {
		if(i > j)
			return 0;
		if(dp[i][j][k] > 0)
			return dp[i][j][k];
		int res = (k+1) * (k+1) + topBottom(dp, i+1,j,0,boxes); // remove the ith box and get K+1^2 points
		for(int idx = i+1; idx <= j; idx++) {
			if(boxes[idx] == boxes[i])
				res = Math.max(res,topBottom(dp,i+1,idx-1,0,boxes)+topBottom(dp,idx,j,k+1,boxes)); // leave the ith box to later use !!
		}
		dp[i][j][k] = res;
		return res;
	}
}
