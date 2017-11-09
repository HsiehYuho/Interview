package quick_sort;

public class _493 {
	public static void main(String[] args) {
		_493 a = new _493();
		a.exe();
	}
	public void exe() {
		int[] nums = new int[] {1,3,2,3,1};
		System.out.println(reversePairs(nums));
		return;
	}
	public int reversePairs(int[] nums) {
		return reversePairsSub(nums,0,nums.length-1);
	}
	public int reversePairsSub(int[] nums, int l, int r) {
		if(l >= r)
			return 0;
		int m = l + ((r-l)>>1);
		int res = reversePairsSub(nums,l,m) + reversePairsSub(nums,m+1,r);
		int[] merge = new int[r-l+1];
		int i = l, j = m+1, mergeIdx = 0, p = m+1;
		// doing the merge process
		while(i <= m) {
			// calculate the res
			while(p <= r && nums[i] > 2L*nums[p]) // L means long to avoid overflow
				p++;
			res += (p-(m+1));
			// doing the merge to do the swap part
			while(j <= r && nums[i] >= nums[j])
				merge[mergeIdx++] = nums[j++];
			// doing the smaller part
			merge[mergeIdx++] = nums[i++];
		}
		while(j <= r)
			merge[mergeIdx++] = nums[j++];
		System.arraycopy(merge, 0, nums, l, r-l+1);
		return res;
	}
}
