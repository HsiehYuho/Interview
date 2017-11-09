package fb;

// there are 3 windows, each with k size, cannot overlap, with biggest sub array sum
public class Three_Windows_K_Max_Sum {
	public static void main(String[] args) {
		Three_Windows_K_Max_Sum a =  new Three_Windows_K_Max_Sum(); 
		a.exe();
		return;
	}
	public void exe() {
		int[] nums = new int[] {1, 3, 7, 7, 2, 1,10};
		System.out.println(maxSubArray(nums,3,2));
		return;
	}
	public int maxSubArray(int[] nums, int k, int n) {  //  with k length, n window
		if(nums == null || nums.length == 0)
			return 0;
		int l = nums.length;
		if( n * k > l)
			return 0;
		int dp[][] = new int[l+1][n+1]; // dp[i][j] means the max value for ith window at num[l]
		int[] preSum = new int[l+1];
		preSum[0] = nums[0];
		for(int i = 1; i <= l; i++) {
			preSum[i] = preSum[i-1] + nums[i-1];
		}
		for(int i = k-1; i < l; i++) {
			for(int j = 0; j < n; j++) {
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i-k+1][j]+(preSum[i+1]-preSum[i+1-k]));
			}
		}
		return dp[l][n];
		
	}
}
