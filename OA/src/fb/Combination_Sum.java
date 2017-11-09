package fb;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    		List<List<Integer>> res = new ArrayList<>();
    		dfs(candidates,target,0,res,new ArrayList<>());
    		return res;
    }
    private void dfs(int[] candidates, int remain, int pos, List<List<Integer>> res, List<Integer> ans) {
    		if(remain == 0) {
    			res.add(new ArrayList<Integer>(ans));
    			return;
    		}
    		if(remain < 0)
    			return;
    		for(int i = pos; i < candidates.length; i++) {
    			ans.add(candidates[i]);
    			dfs(candidates,remain-candidates[i],i,res,ans);
    			ans.remove(ans.size()-1);
    		}
    		return;
    }

}
