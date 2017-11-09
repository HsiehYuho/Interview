package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _247 {
	public static void main(String[] args) {
		_247 a= new _247();
		a.exe();
	}
	public void exe() {
		return;
	}
	public List<String> findStrobogrammatic(int n) {
		return permute(n,n);
    }
	private List<String> permute(int n, int m){
		if( n == 0)
			return new ArrayList<String>(Arrays.asList(""));
		if(n == 1)
			return new ArrayList<String>(Arrays.asList("1","0","8"));
		List<String> list = permute(n-2,m);
		List<String> res = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if(n != m)
				res.add(0+s+0);
			res.add(1+s+1);
			res.add(8+s+8);
			res.add(6+s+9);
			res.add(9+s+6);
		}
		return res;
	}
}
