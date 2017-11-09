package fb;

import java.util.Arrays;

public class Two_Array_Output_All_Smaller_Element_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Two_Array_Output_All_Smaller_Element_Sum sol = new Two_Array_Output_All_Smaller_Element_Sum();
		sol.exe();
	}
	private void exe() {
		int[] arr1 = new int[] {4,7,11};
		int[] arr2 = new int[] {-1,4,14};
		int[] res = find(arr1,arr2);
		for(int n : res)
			System.out.println(n);
		return;
	}
	private int[] find(int[] arr1, int[] arr2) {
		Arrays.sort(arr1);
		int n = arr2.length;
		int[] res = new int[n];
		for(int i = 0; i < n; i++) {
			res[i] = findSum(arr1,arr2[i]);
		}
		return res;
	}
	private int findSum(int[] arr1, int target) {
		int idx = bsearch(arr1,target);
		int sum = 0;
		for(int i = 0; i <= idx; i++) {
			sum += arr1[i];
		}
		return sum;
	}
	private int bsearch(int[] arr, int target) { // return the last element < target 
		int left = 0, right = arr.length-1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] >= target)
				right = mid-1;
			else
				left = mid;
		}
		if(arr[left] >= target)
			return -1;
		if(arr[right] < target)
			return right;
		return left;
	}

}
