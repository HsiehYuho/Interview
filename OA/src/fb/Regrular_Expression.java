package fb;

public class Regrular_Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	// s = aa, p = a*
	public boolean isMatch(String s, String p) {
		// dp[][] to meet
		boolean[][] dp = new boolean[s.length()+1][p.length()+1]; // dp[i][j] means from whether 0 - i-1 can match 0 to j-1
		dp[0][0] = true;
		// initialize the pattern
		for(int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '*' && dp[0][i-1])
				dp[0][i+1] = true;
		}
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < p.length(); j++) {
				// first situation 
				if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
					dp[i+1][j+1] = dp[i][j];
				// second situation 
				if(p.charAt(j) == '*') {
					// empty * = useless
					if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.')
						dp[i+1][j+1] = dp[i+1][j-1];
					// one *  dp[i+1][j]
					// multi * dp[i][j+1]
					// in this situation, also may be empty dp[i+1][j-1]
					else 
						dp[i+1][j+1] = dp[i+1][j] ||  dp[i+1][j-1];
 				}
			}
		}
		return dp[s.length()][p.length()];
    }

}
