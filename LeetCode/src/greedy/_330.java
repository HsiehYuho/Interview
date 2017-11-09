package greedy;

public class _330 {
	public static void main(String[] args) {
		_330 a = new _330();
		a.exe();
	}
	public void exe() {
		System.out.println(minPatches(new int[] {1,2,31,33},2147483647));
		return;
	}
    public int minPatches(int[] nums, int n) {
        int i = 0;
        long miss = 1; // [0,miss), if use int, may encounter overflow
        int ans = 0; 
        while(miss <= n) {
        		if(i < nums.length && nums[i] <= miss){
        			miss += nums[i++];
        		}
        		else {
        			miss += miss;
        			ans++;
        		}
        }
        return ans;
    }
}
