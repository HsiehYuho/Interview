package arithmetic;

import java.util.ArrayList;
import java.util.List;

public class _254 {
	public static void main(String[] args) {
		_254 a = new _254();
		a.exe();
	}
	public void exe() {
		List<List<Integer>> res = getFactors(12);
		for(List<Integer> list : res) {
			for(int i : list)
				System.out.print(i + " ");
			System.out.println();
		}
		return;
	}
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<>();
		for(int i = 2; i*i <= n; i++) {
			if(n % i == 0) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				compute(n/i,res,list,i);
			}
		}
		return res;
    }
	private void compute(int n, List<List<Integer>> res, List<Integer> ans, int m) {
		if(n == 1 && ans.size() != 0) {
			res.add(new ArrayList<Integer>(ans));
			return;
		}
		for(int i = 2; i <= n; i++) {
			if(n % i == 0 && i >= m) {
				ans.add(i);
				compute(n/i,res,ans,i);
				ans.remove(ans.size()-1);
			}
		}
		return;
	}
}
