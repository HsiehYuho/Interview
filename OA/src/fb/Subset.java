package fb;

import java.util.List;
import java.util.ArrayList;

public class Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	// dfs, termination condition, add every subset, duplicate problem, with distinct
    // how to loop the recursive 
	// the add and remove position in the loop!!
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
    	dfs(res,new ArrayList<>(),nums,0);
        res.add(new ArrayList<>());
		return res;
}
public void dfs(List<List<Integer>> res, List<Integer> ans, int[] nums, int pos) {
        if(pos == nums.length)
			return;
		for(int i = pos; i < nums.length; i++) {
            ans.add(nums[i]);
            res.add(new ArrayList<>(ans));
            dfs(res,ans,nums,i+1);
            ans.remove(ans.size()-1);
		}
		return;    
    }
    

}
