package fb;

import java.util.LinkedList;

public class String_Manipulation {
	public static void main(String[] args) {
		String_Manipulation a = new String_Manipulation();
		a.exe();
		return;
	}
	public void exe() {
		int[] input = new int[] {5,5,5,5};
		int[] ans = manipulate(input);
		for(int i : ans)
			System.out.println(i);
	}
	public int[] manipulate(int[] nums) {
		if(nums == null || nums.length == 0)
			return new int[0];
		LinkedList<Integer> list = new LinkedList<>();
		int add = 0;
		for(int i = nums.length-1; i >= 0; i--) {
			int n = nums[i];
			n *= 2;
			n += add;
			if(n / 10 >= 1) {
				add = n/10;
			}
			list.add(0,n%10);
		}
		if(add != 0)
			list.add(0,add);
		int[] ans = new int[list.size()];
		for(int i = 0; i < list.size(); i++)
			ans[i] = list.get(i);
		return ans;
	}
	
}
