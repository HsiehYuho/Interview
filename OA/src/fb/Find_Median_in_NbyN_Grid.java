package fb;

import java.util.PriorityQueue;

public class Find_Median_in_NbyN_Grid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Median_in_NbyN_Grid sol = new Find_Median_in_NbyN_Grid();
		sol.exe();
	}
	private void exe() {
		int[][] matrix = new int[][] {{1,5,10},{-3,-2,-1},{-10,2,5}};
		System.out.println(findMid(matrix));
		return;
	}
	private int findMid(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		boolean odd = ((m*n)&1) == 1;
		int count = (m*n+1) / 2;
		// if odd pick 2, else pick 1
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
		for(int i = 0; i < m; i++)
			pq.add(new int[] {matrix[i][0],i,0});
		int mid = pq.peek()[0];
		while(count != 0) {
			int[] num = pq.remove();
			mid = num[0];
			int idx = num[1];
			int eleIdx = num[2]+1;
			if(eleIdx < n)
				pq.add(new int[] {matrix[idx][eleIdx],idx,eleIdx});
			count--;
		}
		if(odd)
			return mid;
		else
			return (mid+pq.peek()[0]) / 2;
		
		
	}
	private int bsearch(int[] nums, int target) { // find the number index which is less than or equal to target 
		int left = 0, right = nums.length - 1;
		while(left + 1 < right) {
			int mid = left + (right - left) / 2;
			if(nums[mid] == target)
				return mid;
			if(nums[mid] > target)
				right = mid;
			else
				left = mid;
		}
		if(nums[right] < target)
			return right;
		if(nums[left] > target)
			return -1;
		return left;
	}

}
