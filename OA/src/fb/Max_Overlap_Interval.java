package fb;

import java.util.PriorityQueue;

public class Max_Overlap_Interval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Max_Overlap_Interval sol = new Max_Overlap_Interval();
		sol.exe();
	}
	private void exe() {
		int[][] nums = new int[][] {{1,3},{3,7},{2,9},{1,10},{8,10},{9,11}};
		Interval[] intervals = new Interval[nums.length];
		for(int i = 0 ; i < nums.length; i++) {
			int[] tmp = nums[i];
			intervals[i] = new Interval(tmp[0],tmp[1]);
		}
		System.out.println(findMax(intervals));
		return;
	}
	private int findMax(Interval[] intervals) {
		PriorityQueue<Integer> arrive = new PriorityQueue<>();
		PriorityQueue<Integer> leave = new PriorityQueue<>();
		for(Interval i : intervals) {
			arrive.offer(i.start);
			leave.offer(i.end);
		}
		int count = 0;
		int max = 0;
		while(arrive.size() != 0 && leave.size() != 0){
			int start = arrive.peek();
			int end = leave.peek();
			if(start >= end ) {
				count--;
				leave.poll();
			}
			else {
				count++;
				arrive.poll();
			}
			max = Math.max(count, max);
		}
		return max;
	}
	private class Interval{
		int start;
		int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}
