package array_sum_up;

public class _308 {
	public static void main(String[] args) {
		_308 a= new _308();
		a.exe();
	}
	public void exe() {
		return;
	}
	int[][] matrix;
	int[][] colSum;
	public void NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
        		return;
        int m = matrix.length;
        int n = matrix[0].length;
        this.matrix = matrix;
        colSum = new int[m+1][n]; // colSum[i][j] = matrix[0][j] + matrix[1][j] +...+matrix[i-1][j]
        for(int i = 1; i <= m; i++) {
        		for(int j = 0; j < n; j++) {
        			colSum[i][j] = colSum[i-1][j] + matrix[i-1][j];
        		}
        }
    }
    
    public void update(int row, int col, int val) {
        for(int i = row+1; i < colSum.length; i++)
        		colSum[i][col] = colSum[i][col] - matrix[row][col] + val;
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    		int res = 0;
    		for(int j = col1; j <= col2; j++)
    			res += colSum[row2+1][j] - colSum[row1][j];
        return res;
    }
}
