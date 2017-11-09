package hashmap_application;

import java.util.HashMap;

public class _560 {
	public static void main(String[] args) {
		_560 a = new _560();
		a.exe();
	}
	public void exe() {
		int[] nums = new int[] {1,2,3,2,1,1,1};
		int k = 10;
		System.out.println(subarraySum(nums,k));
		return;
	}
	public int subarraySum(int[] nums, int k) {
		int sum = 0, res = 0; // preSum = sum[i~j] = sum[0~j] - sum[0~i-1], HashMap<(0~j], freq>
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0,1); // 0 ~ 0 equals 0, happen 1 time
		for(int i : nums) {
			sum += i;
			if(map.containsKey(sum-k)) { // 0~i-1 = sum-k, 0~j = sum -> i ~ j = (sum - (sum-k))
				res += map.get(sum-k);
			}
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return res;
    }
}
