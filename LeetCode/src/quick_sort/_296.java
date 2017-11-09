package quick_sort;

import java.util.ArrayList;

public class _296 {
	public static void main(String[] args) {
		_296 a = new _296();
		a.exe();
	}
	public void exe() {
		int[][] grid = new int[][] {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(minTotalDistance(grid));
		return;
	}
    public int minTotalDistance(int[][] grid) {
    		ArrayList<Integer> x = new ArrayList<>();
    		ArrayList<Integer> y = new ArrayList<>();
    		int m = grid.length, n = grid[0].length;
    		for(int i = 0; i < m; i++) {
    			for(int j = 0; j < n; j++) {
    				if(grid[i][j] == 1) {
    					x.add(i); 
    					y.add(j);
    				}
    			}
    		}
    		int midX = getMid(x,0,x.size()-1,x.size()/2);
    		int midY = getMid(y,0,y.size()-1,y.size()/2);
    		System.out.println(midX);
    		System.out.println(midY);
    		int res = 0;
    		for(int i : x)
    			res += Math.abs(i-midX);
    		for(int j : y)
    			res += Math.abs(j-midY);
    		return res;
    }
    private int getMid(ArrayList<Integer> list, int start, int end, int target) {
    		int left = start, right = end;
    		int pivot = list.get(right);
    		while(true) {
    			while(left < right && list.get(left) < pivot)
    				left++;
    			while(right > left && list.get(right) >= pivot)
    				right--;
    			if(left == right)
    				break;
    			swap(list,left,right);
    		}
    		swap(list,left,end);
    		if((left) == target) // left is the index, not the relative, we should take the left or left + 1 into account 
    			return pivot;
    		else if ((left) > target)
    			return getMid(list,start,left-1,target); 
    		else
    			return getMid(list,left+1,end,target);
    }
    private void swap(ArrayList<Integer> list, int i, int j) {
    		int tmp = list.get(i);
    		list.set(i, list.get(j));
    		list.set(j, tmp);
    		return;
    }
}
