package silding_window;

import java.util.TreeMap;

public class _480 {
	public static void main(String[] args) {
		_480 a = new _480();
		a.exe();
	}
	public void exe() {
		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		double[] res = medianSlidingWindow(nums,3);
		for(double i : res)
			System.out.print(i + " ");
		return;
	}
	public double[] medianSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		double[] res = new double[n - k + 1];
		TreeMap<Integer, Integer> smallMap = new TreeMap<>((a,b) -> (int)((double) b - a));
		// [4,2,1,1,-1]
		TreeMap<Integer, Integer> bigMap = new TreeMap<>();
		// [5,6,7,10,15]
		int smSize = 0, bgSize = 0; // becase treemap.size != smSize for the duplicate reason 
		int resIdx = 0;
		boolean odd = ((k&1) == 1);
		for(int i = 0; i < n; i++) {
			// keep the window == k
			if((smSize + bgSize) == k) {
				if(nums[i-k] <= smallMap.firstKey()) {
					remove(smallMap,nums[i-k]);
					smSize--;
				}
				else {
					remove(bigMap,nums[i-k]);
					bgSize--;
				}
			}
			if(smSize <= bgSize) { // keep smallMap no smaller than bigMap
				add(smallMap,nums[i]);
				smSize++;
			}
			else {
				add(bigMap,nums[i]);
				bgSize++;
			}
			if(bgSize > 0) {
				// swapping
				while(smallMap.firstKey() > bigMap.firstKey()) {
					add(smallMap,remove(bigMap,bigMap.firstKey()));
					add(bigMap,remove(smallMap,smallMap.firstKey()));
				}
			}
			// add res answer
			if(smSize+bgSize == k) {
				if(odd) {
					res[resIdx++] = smallMap.firstKey();
				}
				else {
					double mean = (double) smallMap.firstKey() + bigMap.firstKey(); // this double to keep not overflow
					res[resIdx++] = mean/2.0;
				}
			}
		}
		return res;
	}
	private int remove(TreeMap<Integer, Integer> map, int i) { // return the remove i element is important
		Integer count = map.get(i);
		if(count == 1) 
			map.remove(i);
		else 
			map.put(i, count-1);
		return i;
	}
	private void add(TreeMap<Integer,Integer> map, int i) {
		map.put(i, map.getOrDefault(i, 0)+1);
	}
}
