package fb;

public class _209 {

	public static void main(String[] args) {
		return;
	}
	// super easy sliding window
    public int minSubArrayLen(int s, int[] nums) {
    		int left = 0, right = 0;
    		int sum = 0, min = Integer.MAX_VALUE;
    		int n = nums.length;
    		while(right < n) {
    			sum += nums[right++];
    			while(sum >= s) {
    				// put the min here can avoid two phase comparison, once enter min while loop  
    				min = Math.min(min, right-left);
    				sum -= nums[left++];
    			}
    		}
    		return min == Integer.MAX_VALUE ? 0 : min;
    }

}
