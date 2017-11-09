package fb;

public class Max_Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
        		return 0;
        int m = matrix.length, n = matrix[0].length;
    		int[][] dp = new int[m][n];
    		int max = 0; // the length of squre
    		for(int i = 0; i < m; i++) {
    			for(int j =  0; j < n; j++) {
    				if(matrix[i][j] == '1') {
        				if(i == 0 || j == 0 )
        					dp[i][j] = 1;
        				else {
        					dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
        				}
        				max = Math.max(dp[i][j], max);
    				}
    			}
    		}
    		return max*max;
    }

}
