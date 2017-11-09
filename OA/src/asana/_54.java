package asana;

import java.util.ArrayList;
import java.util.List;

public class _54 {
	public static void main(String[] args) {
		return;
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if(matrix == null || matrix.length == 0)
            return list;
		int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
		while (down >= up && left <= right) {
			for (int i = up, j = left; j <= right; j++) {
				list.add(matrix[i][j]);
			}
			up++;
			for (int i = up, j = right; i <= down; i++) {
				list.add(matrix[i][j]);
			}
			right--;
			for (int i = down, j = right; down >= up && j >= left; j--) {
				list.add(matrix[i][j]);
			}
			down--;
			for (int i = down, j = left; left <= right && i >= up; i--) {
				list.add(matrix[i][j]);
			}
			left++;
		}
		return list;
	}
}
