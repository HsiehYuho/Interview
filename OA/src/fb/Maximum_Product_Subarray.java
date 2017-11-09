package fb;

public class Maximum_Product_Subarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maximum_Product_Subarray a = new Maximum_Product_Subarray();
		a.exe();
	}
	public void exe() {
		int[] nums = new int[] {1,5,-3,-5,-2};
		System.out.println(maxProduct(nums));
		return;
	}
    public int maxProduct(int[] nums) {
    		// 1 5 -3 5 -2
    		if(nums == null || nums.length == 0)
    			return 0;
    		int m = nums.length;
    		int dp[][][] = new int [m][m][2]; // dp[i][j] means from i to j the maximum value
    		int max = Integer.MIN_VALUE;
    		for(int i = 0; i < m; i++) {
    			dp[i][i][0] = nums[i];
    			dp[i][i][1] = nums[i];
    			max = Math.max(max,nums[i]);
    		}
    		for(int j = 1; j < m; j++) {
    			for(int i = 0; i < j; i++) {
    				int maxCurr = dp[i][j-1][0] * nums[j], minCurr = dp[i][j-1][1] * nums[j];
    				dp[i][j][0] = Math.max(maxCurr,minCurr);
    				dp[i][j][1] = Math.min(maxCurr,minCurr);
    				max = Math.max(dp[i][j][0], max);
    			}
    		}
    		return max;
    }

}
