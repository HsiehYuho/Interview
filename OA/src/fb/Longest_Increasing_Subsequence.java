package fb;

public class Longest_Increasing_Subsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		for(int i = 0; i < nums.length; i++)
			dp[i] = 1;
		for(int j = 1; j < nums.length; j++) {
			for(int i = 0; i <= j; i++) {
				if(nums[j] > nums[i]) {
					if(dp[j] < dp[i]+1)
						dp[j] = dp[i]+1;
				}
			}
		}
		int max = 0;
		for(int d : dp)
			max = Math.max(d,max);
		return max;
	}

}
