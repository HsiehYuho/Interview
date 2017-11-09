package arithmetic;


public class _321 {
	public static void main(String[] args) {
		_321 a = new _321();
		a.exe();
	}
	public void exe() {
		int[] ans = maxNumber(new int[] {6,7}, new int[] {6,0,4}, 5);
		for(int i : ans)
			System.out.print(i + " ");
		return;
	}
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        // first step : to find out the maximum number in a single array for length i
		int[] newNums1 = null;
		int[] newNums2 = null;
		int[] res = new int[k];
		for(int i = Math.max(0, k-nums2.length); i <= Math.min(nums1.length, k); i++) {
			int[] temp = new int[k];
			newNums1 = new int[i];
			newNums2 = new int[k-i];
			findMaxInArray(nums1,newNums1);
			findMaxInArray(nums2,newNums2);
			int index = 0;
			int i1 = 0, i2 = 0;
			while(index < k) {
				if(greater(newNums1,newNums2,i1,i2))
					temp[index++] = newNums1[i1++];
				else
					temp[index++] = newNums2[i2++];
			}
			if(greater(temp,res,0,0))
				res = temp;
		}
		return res;
    }
	private boolean greater(int[] r1, int[] r2, int i, int j) { // r1[i] > r2[j] ? 
		for(; i < r1.length && j < r2.length; i++,j++) {
			if(r1[i] > r2[j])
				return true;
			if(r2[j] > r1[i])
				return false;
		}
		return i != r1.length;
	
	}
	private void findMaxInArray(int[] nums, int[] ans) {
		int index = 0, k = ans.length, n = nums.length; // k = limited length
		for(int i = 0; i < n; i++) {
			while(index > 0 && index + (n-i) > k && ans[index-1] < nums[i]) // hardest
				index--;
			if(index < k)
				ans[index++] = nums[i];
		}
		return;
	}
}
