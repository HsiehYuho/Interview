package fb;

import java.util.TreeSet;

public class _363 {

	public static void main(String[] args) {
		return;
	}
	// there is a O^4 solution, naive, but solvable, and can use tree to improve it
    public int maxSumSubmatrix(int[][] matrix, int k) {
    		int m = matrix.length, n = matrix[0].length;
    		int max = Integer.MIN_VALUE;
    		int[][] areas = new int[m][n];
    		for(int i = 0; i < m; i++) {
    			for(int j = 0; j < n; j++) {
    				areas[i][j] = matrix[i][j];
    				if(i > 0)
    					areas[i][j] += areas[i-1][j];
    				if(j > 0)
    					areas[i][j] += areas[i][j-1];
    				// important, there may be add duplicate
    				if(i > 0 && j > 0)
    					areas[i][j] -= areas[i-1][j-1];
    			}
    		}
    		// calculate
    		for(int r1 = 0; r1 < m; r1++) {
    			for(int r2 = r1; r2 < m; r2++) { // not r2 = r1+1, will miss one row
    				TreeSet<Integer> tree = new TreeSet<>();
    				tree.add(0); // important, these prevent the first col answer missing
    				for(int c = 0; c < n; c++) {
        				int area = areas[r2][c];
    					if(r1 > 0) {
        					area -= areas[r1-1][c]; // take the largest
    					} // if r1 == 0, we should not take that minus into account
    					Integer ceil = tree.ceiling(area - k);
    					if(ceil != null)
    						max = Math.max(max, area - ceil);
    					tree.add(area);
    					
    				}
    			}
    		}
    		return max;
    }

}
