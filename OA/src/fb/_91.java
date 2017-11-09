package fb;

public class _91 {
	public static void main(String[] args) {
		return;
	}
    public int numDecodings(String s) {
    	// bottom up and use dp[i] = dp[i+1] && dp[i] += dp[i+2]
    		int n = s.length();
    		if(n == 0)
    			return 0;
    		int[] dp = new int[n+1]; // dp[i] means the number of decode way from i to end
    		dp[n] = 1;
    		for(int i = n-1; i >= 0; i--) {
    			if(s.charAt(i) == '0') {
    				dp[i] = 0;
    				continue;
    			}
    			dp[i] = dp[i+1];
    			if(i < n-1 && (s.charAt(i) == '1' || (s.charAt(i) =='2' && s.charAt(i+1) < '7')))
    				dp[i] += dp[i+2];
    	    	}
    		return dp[0];
    }
}
