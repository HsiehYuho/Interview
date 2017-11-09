package hashmap_application;

import java.util.HashMap;

public class _325 {
	public static void main(String[] args) {
		_325 a = new _325();
		a.exe();
	}
	public void exe() {
		int[] nums = new int[] {-2, -1, 2, 1};
		System.out.println(maxSubArrayLen(nums,1));
		return;
	}
    public int maxSubArrayLen(int[] nums, int k) {
    		HashMap<Integer,Integer> map = new HashMap<>(); // cumulative -> index
    		map.put(0, 0);
    		int cul = 0, max = 0;
    		for(int i = 0; i < nums.length; i++) {
    			cul += nums[i];
    			if(!map.containsKey(cul))
    				map.put(cul,i+1);
    			if(map.containsKey(cul-k)) {
    				max = Math.max((i-map.get(cul-k))+1,max);
    			}
    		}
    		return max;
    }
}

