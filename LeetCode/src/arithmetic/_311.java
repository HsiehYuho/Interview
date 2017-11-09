package arithmetic;

public class _311 {
	public static void main(String[] args) {
		_311 a = new _311();
		a.exe();
	}
	public void exe() {
		
		return;
	}
	public int[][] multiply(int[][] A, int[][] B) {
		int m = A.length;
		int n = B[0].length;
		int[][] res = new int[m][n];
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < B[0].length; j++) {
				res[i][j] = compute(A,B,i,j);
			}
		}
		return res;
		
    }
	private int compute(int[][] a, int[][] b, int i, int j) {
		int res = 0;
		for(int k = 0; k < a[0].length; k++) {
			res += a[i][k] * b[k][j]; 
		}
		return res;    
	}
}
