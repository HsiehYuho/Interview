package fb;

public class Decode_Ways {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	public int numDecodings(String s) {
		if(s == null || s.length() == 0)
			return 0;
		int dp[] = new int[s.length()+1]; // dp[i] = means from 0 to i-1th , how many ways 
		int n = s.length();
		dp[n] = 1; // base case has 1 way
		for(int i = n-1; i >= 0; i--) {
			char cur = s.charAt(i);
			if(cur == '0') { // zero must come with the next char (X0)
				dp[i] = 0;
				continue;
			}
			dp[i] = dp[i+1];
			
			if (i < n-1 && (cur == '1' || (cur == '2' && (s.charAt(i+1) - '0') <= 6)))
				dp[i] += dp[i+2]; 
		}
		return dp[0];
	}

}
