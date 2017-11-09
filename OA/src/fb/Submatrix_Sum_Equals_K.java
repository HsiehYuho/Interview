package fb;

import java.util.TreeSet;

public class Submatrix_Sum_Equals_K {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	public int maxSumSubmatrix(int[][] matrix, int k) {
		if(matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length, n = matrix[0].length;
		int max = Integer.MIN_VALUE;
		int[][] preSum = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				int tmpSum = matrix[i][j];
				if(i >= 1)
					tmpSum += preSum[i-1][j];
				if(j >= 1)
					tmpSum += preSum[i][j-1];
				if(i >= 1 && j >= 1)
					tmpSum -= preSum[i-1][j-1];
				preSum[i][j] = tmpSum;
			}
		}
		for(int r1 = 0; r1 < m; r1++) {
			for(int r2 = r1; r2< m; r2++) {
				TreeSet<Integer> treeSet = new TreeSet<>();
				treeSet.add(0);
				for(int j = 0; j < n; j++) {
					int area = preSum[r2][j];
					if(r1 >= 1)
						area -= preSum[r1-1][j];
					Integer ceil = treeSet.ceiling(area-k);
					if(ceil != null)
						max = Math.max(area-ceil, max);
					treeSet.add(area);
				}
			}
		}
		return max;
	}
	
}
