package fb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Merge_Interval {
	public static void main(String[] args) {
		Merge_Interval a = new Merge_Interval();
		a.exe();
	}
	public class Interval {
	     int start;
	     int end;
	     Interval() { start = 0; end = 0; }
	     Interval(int s, int e) { start = s; end = e; }
	}
	public void exe() {
		return;
	}
	// analyze the different situation, from start < end , start > end , start == end
    // be careful with sort by start or end!
	public List<Interval> merge(List<Interval> intervals) {
	    	Collections.sort(intervals, new Comparator<Interval>() {
	    		@Override
	    		public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
	    	});
	    	List<Interval> res = new ArrayList<>();
	    	int idx = 0;
	    	while(idx < intervals.size()) {
		    	int curStart = intervals.get(idx).start;
		    	int curEnd = intervals.get(idx).end;
		    	while(idx+1 < intervals.size()) {
		    		if(curEnd >= intervals.get(idx+1).start) {
		    			curEnd  = Math.max(intervals.get(idx+1).end, curEnd);		    			curStart = 
		    			idx++;
		    		}
		    		else
		    			break;
		    	}
		    	res.add(new Interval(curStart,curEnd));
		    	idx++;
	    	}
	    	return res;
    
    }
}
