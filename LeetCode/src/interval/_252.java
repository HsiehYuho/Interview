package interval;

import java.util.Arrays;
import java.util.Comparator;

public class _252 {
	public static void main(String[] args) {
		_252 a = new _252();
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
    public boolean canAttendMeetings(Interval[] intervals) {
    		Arrays.sort(intervals,new cmp());
    		int end = Integer.MIN_VALUE;
    		for(int i = 0; i < intervals.length; i++) {
    			int start = intervals[i].start;
    			if(end > start) {
    				return false;
    			}
    			else {
    				end = intervals[i].end;
    			}
    		}
    		return true;
    }
    private class cmp implements Comparator<Interval>{
    		public int compare(Interval a, Interval b) {
    			return a.start - b.start;
    		}
    }
}
