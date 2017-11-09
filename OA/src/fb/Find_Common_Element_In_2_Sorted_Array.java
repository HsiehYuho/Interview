package fb;

import java.util.ArrayList;
import java.util.List;

public class Find_Common_Element_In_2_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_Common_Element_In_2_Sorted_Array sol = new Find_Common_Element_In_2_Sorted_Array();
		sol.exe();
	}
	private void exe() {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		for(int i = 0; i < 10; i+=2) {
			l1.add(i);
			if(i == 2) {
				l1.add(2);
				l1.add(2);
			}
		}
		for(int j = 1; j < 10; j++) {
			l2.add(j);
			if(j == 2)
				l2.add(2);
		}
		List<Integer> res = findCommonElemetn(l1,l2);
		for(int n : res)
			System.out.print(n);
		return;
	}
	private List<Integer> findCommonElemetn(List<Integer> list1, List<Integer> list2){
		List<Integer> res = new ArrayList<>();
		if(list1.size() > list2.size()) {
			List<Integer> tmp = list1;
			list1 = list2;
			list2 = tmp;
		}
		int ptr = 0;
		while(ptr < list1.size()) {
			int pre = ptr;
			int num = list1.get(ptr);
			ptr++;
			while(ptr < list1.size() && list1.get(ptr) == list1.get(ptr-1))
				ptr++;
			int count1 = ptr - pre;
			int idx1 = findFirstAppear(list2,num,true); // we can set up another idx for record 
			if(idx1 == -1)
				continue;
			int idx2 = findFirstAppear(list2,num+1,false);
			System.out.println("num:" + num +" idx1:" + idx1 + " idx2:"+idx2);
			int count2 = idx2 - idx1;
			int min = Math.min(count1, count2);
			for(int i = 0; i < min; i++) {
				res.add(num);
			}
		}
		return res;
	}
	private int findFirstAppear(List<Integer> list, int target, boolean mustFind) {
		int left = 0, right = list.size()-1;
		while(left +1 <  right) {
			int mid = left + (right - left) / 2;
			if(list.get(mid) < target)
				left = mid + 1;
			else
				right = mid;
		}
		//
		if(mustFind) {
			if(list.get(left) == target)
				return left;
			if(list.get(right) == target)
				return right;
			return -1;
		}
		else {
			if(list.get(right) < target)
				return right + 1;
			if(list.get(left) >= target)
				return left;
			return right;			
		}
	}
	

}
