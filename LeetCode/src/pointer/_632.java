package pointer;

import java.util.List;
import java.util.PriorityQueue;

public class _632 {
	public static void main(String[] args) {
		_632 a = new _632();
		a.exe();
	}
	public void exe() {
		return;
	}
	public int[] smallestRange(List<List<Integer>> nums) {
		int n = nums.size();
		int[] sR = new int[2]; // means smallestRange
		sR[0] = Integer.MAX_VALUE;
		sR[1] = Integer.MIN_VALUE;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2]-b[2])); // [ith,pointer,val], smallest move first
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i ++) {
			int tmp = nums.get(i).get(0);
			max = Math.max(tmp, max);
			pq.add(new int[] {i,0,tmp}); 
		}
		sR[0] = pq.peek()[2];
		sR[1] = max;
		while(pq.size() == n) {
			int range = sR[1] - sR[0];
			int[] node = pq.poll();
			int min = node[2];
			if((max - min) < range) { // using priorityqueue, so do not need to concern a == c
				sR[0] = min;
				sR[1] = max;
			}
			if(node[1]+1 < nums.get(node[0]).size()) {
				int val = nums.get(node[0]).get(node[1]+1);
				max = Math.max(val,max); // maintain max
				int[] newNode = new int[] {node[0],node[1]+1,val};
				pq.offer(newNode);
			}
		}
		return sR;
    }
}
