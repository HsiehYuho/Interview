package api_design;

import java.util.ArrayList;

public class _295 {
	public static void main(String[] args) {
		_295 a = new _295();
		a.exe();
	}
	public void exe() {
		MedianFinder();
		int[] ar = new int[] {1,2};
		for(int i : ar)
			addNum(i);		
		System.out.println(findMedian());
	}
	// initialize data structure here
	ArrayList<Integer> list;
	public void MedianFinder() {
		list = new ArrayList<>();
	}
	public void addNum(int num) {
		int left = 0, right = list.size();
		while(left < right) {
//			System.out.println("test");
			int mid = left + (right - left) / 2;
			int comp = list.get(mid);
			if(comp == num) {
				list.add(mid,num);
				return;
			}
			else if(comp > num) {
				right = mid;
			}
			else 
				left = mid+1;
		}
		list.add(right,num);
		for(int i : list)
			System.out.print(i);
		System.out.println();
		return;
	}
		    
	public double findMedian() {
		int size = list.size();
		if((size&1) == 1) // odd
			return list.get(size/2);
		else {
			return ((double)list.get(size/2) + (double)list.get(size/2-1))/2;
		}
	}	
}
