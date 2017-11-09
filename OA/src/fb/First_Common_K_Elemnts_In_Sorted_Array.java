package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class First_Common_K_Elemnts_In_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		First_Common_K_Elemnts_In_Sorted_Array sol = new First_Common_K_Elemnts_In_Sorted_Array();
		sol.exe();
	}
	private void exe() {
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = Arrays.asList(1,4,5);
		List<Integer> list3 = Arrays.asList(1,2);
		List<Integer> list4 = Arrays.asList(5,5,5,5);
		List<List<Integer>> res = new ArrayList<>();
		res.add(list1);
		res.add(list2);
		res.add(list3);
		res.add(list4);
		System.out.println(findKElements(res,3));
		
		
		return;
	}
	private int findKElements(List<List<Integer>> nums, int k) {
		int n = nums.size();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);  // store the number and its index of nums, and itself index
		for(int i = 0 ; i < n; i++) {
			pq.add( new int[] {nums.get(i).get(0),i,0});
		}
		int pre = Integer.MAX_VALUE;
		int count = 0;
		while(pq.size() != 0) {
			int[] cur = pq.poll();
			if(pre != cur[0]) {
				pre = cur[0];
				count = 1;
			}
			else {
				count++;
				if(count >= k)
					return cur[0];
			}
			if(cur[2]+1 >= nums.get(cur[1]).size())
				continue;
			int[] next = new int[] {nums.get(cur[1]).get(cur[2]+1),cur[1],cur[2]+1};
			pq.add(next);
		}
		return -1;
	}

}
