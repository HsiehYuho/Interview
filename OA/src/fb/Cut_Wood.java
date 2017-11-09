package fb;

public class Cut_Wood {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cut_Wood sol = new Cut_Wood();
		sol.exe();
	}
	private void exe() {
		int[] nums = new int[] {1,3,5,6,7};
		System.out.println(cut(nums,5));
		return;
	}
	private int cut(int[] nums, int k) {
		int sum = 0;
		for(int i : nums)
			sum += i;
		int right = sum / k;
		int left = 1;
		if(right <= 0)
			return -1;
		while(left+1 < right) {
			int mid = left + (right - left) / 2;
			int count = 0;
			for(int i : nums)
				count += (i / mid);
			if(count >= k)
				left = mid;
			else
				right = mid;
		}
		int rightCount = 0;
		for(int i : nums)
			rightCount += i / right;
		if(rightCount >= k)
			return right;
		else
			return left;
	}

}
