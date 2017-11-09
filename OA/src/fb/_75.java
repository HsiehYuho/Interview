package fb;

public class _75 {

	public static void main(String[] args) {
		int[] nums = new int[] {2,2,2,1,1,0,1,2,};
		sortColors(nums);
		for(int i : nums)
			System.out.print(i + " ");
		return;
	}
	// index r = 0, b = len -1, loop i towards b, 
	// if color[i] blue swap to color[b--], if color[i] red swap to color[r++]
    public static void sortColors(int[] nums) {
    		int n = nums.length;
    		int r = 0, b = n-1;
    		int w = 0;
    		while(w < n) {
    			if(nums[w] == 1) {
    				w++;
    				continue;
    			}
    			else if(w > r && nums[w] == 0) {
    				int tmp = nums[r];
    				nums[r] = 0;
    				nums[w] = tmp;
    				while(r < n && nums[r] == 0)
    					r++;
    			}
    			else if(w < b && nums[w] == 2) {
    				int tmp = nums[b];
    				nums[b] = 2;
    				nums[w] = tmp;
    				while(b >= 0 && nums[b] == 2)
    					b--;
    			}
    			else
    				w++;    				
    		}
    		return;

    }

}
