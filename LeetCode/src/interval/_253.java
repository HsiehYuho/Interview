package interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


public class _253 {
	public static void main(String[] args) {
		_253 a = new _253();
		a.exe();
	}
	public void exe() {
		return;
	}
	public class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
    public int minMeetingRooms(Interval[] intervals) {
    		Arrays.sort(intervals,new cmp());
    		PriorityQueue<Integer> pq = new PriorityQueue<>();
    		pq.offer(Integer.MIN_VALUE);
    		int minRequire = 0;
    		for(int i = 0; i < intervals.length; i++) {
    			if(pq.peek() <= intervals[i].start) {
    				pq.poll();
    			}
    			pq.offer(intervals[i].end);
    			minRequire = Math.max(pq.size(), minRequire);
    		}
    		return minRequire;
    }
    private class cmp implements Comparator<Interval>{
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
    }
}
