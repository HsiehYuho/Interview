package fb;

public class Move_Zero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Move_Zero a = new Move_Zero();
		a.exe();
		return;
	}
	private void exe() {
		int[] nums = new int[] {2,1,0,0,5,4,3,0};
		moveZeroes(nums);
		for(int i : nums)
				System.out.println(i);
		return;
		
	}
    private void moveZeroes(int[] nums) {
    		int zeroPtr = 0;
    		while(zeroPtr < nums.length && nums[zeroPtr] != 0)
    			zeroPtr++;
    		int otherPtr = zeroPtr+1;
    		while(otherPtr < nums.length && nums[otherPtr] == 0)
    			otherPtr++;
    		while(zeroPtr < nums.length && otherPtr < nums.length) {
    			while(zeroPtr < nums.length && nums[zeroPtr] != 0 )
    				zeroPtr++;
    			while(otherPtr <nums.length && nums[otherPtr] == 0)
    				otherPtr++;
    			if(zeroPtr < nums.length && otherPtr < nums.length)
    				swap(nums,zeroPtr,otherPtr);
    			zeroPtr++;
    			otherPtr++;
    		}
    }
    private void swap(int[] nums, int i, int j) {
    		int tmp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = tmp;
    		return;
    }
}
