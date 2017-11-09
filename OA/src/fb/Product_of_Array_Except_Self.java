package fb;

public class Product_of_Array_Except_Self {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	public int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
		for(int i = 1; i < nums.length; i++) {
			output[i] = output[i-1] * nums[i-1];
		}
		for(int j = nums.length-2; j >= 0; j--) {
			output[j] *= output[j+1] * nums[j+1];
		}
		return output;
    }

}
