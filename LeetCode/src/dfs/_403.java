package dfs;

import java.util.HashSet;

public class _403 {
	public static void main(String[] args) {
		_403 a = new _403();
		a.exe();
	}
	public void exe() {
		System.out.println(canCross(new int[] {0,1,2,3,4,8,9,11}));
		return;
	}
	public boolean canCross(int[] stones) {
		HashSet<Integer> set = new HashSet<>();
		if(stones.length == 1)
			return true;
		if(stones.length == 2) {
			if(stones[1] != 1)
				return false;
			return true;
		}
		for(int i = 2; i < stones.length; i++) {
			if(stones[i] > stones[i-1]*2)  // the most accelerate
				return false;
			set.add(stones[i]);
		}
		int last = stones[stones.length-1];
		return dfs(set,1,1,last);
		
	}
	private boolean dfs(HashSet<Integer> set, int pos, int unit, int last) { // unit is its last jump
		if(unit == 0)
			return false;
		if(Math.abs(last - (pos+unit)) <= 1)
			return true;
		if(set.contains(pos + unit +1))
			if(dfs(set,(pos+unit+1),unit+1,last))
				return true;
		if(set.contains(pos + unit))
			if(dfs(set,(pos+unit),unit,last))
				return true;
		if(set.contains(pos + unit -1))
			if(dfs(set,(pos+unit-1),unit-1,last))
				return true;
		return false;
	}
}
