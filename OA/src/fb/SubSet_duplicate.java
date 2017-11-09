package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet_duplicate {
	public static void main(String[] args) {
		return;
	}
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    		List<List<Integer>> res = new ArrayList<>();
    		List<Integer> ans = new ArrayList<>();
    		Arrays.sort(nums);
    		subset(res,ans,0,nums);
    		return res;
    }
    private void subset(List<List<Integer>> res, List<Integer> ans, int pos,int[] nums) {
    		if(ans.size() <= nums.length)
    			res.add(new ArrayList<Integer>(ans));
    		int i = pos;
    		while(i < nums.length) {
    			ans.add(nums[i]);
    			subset(res,ans,i+1,nums);
    			ans.remove(ans.size()-1);
    			i++;
    			while(i < nums.length && nums[i] == nums[i-1])
    				i++;
    		}
    		// 1 2 2 2 -> 
    		// 1 2 2 2 (1),(1,2),(1,2,2) (1,2,2,2)
    		// 2 2 2 -> (2),(2,2),(2,2,2)
    		// -> none
    		
    		
    }
}
