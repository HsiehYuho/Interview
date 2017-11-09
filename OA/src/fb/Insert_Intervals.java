package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Insert_Intervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	 	// build a priorityqueue needs O(n), insert O(logn) remove O(logn)
    		PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> (a.start == b.start ? b.end - a.end : a.start - b.start));
    	 	for(Interval i : intervals)
    	 		pq.add(i);
    	 	List<Interval> res = new ArrayList<>();
    	 	while(pq.size() > 0) {
        	 	Interval tmp = pq.poll();
    	 		if(tmp.end < newInterval.start)
    	 			res.add(tmp);
    	 		else if(tmp.end >= newInterval.start && tmp.start <= newInterval.end) {
    	 			newInterval= new Interval(Math.min(tmp.start, newInterval.start),Math.max(tmp.end,newInterval.end));
    	 		}
    	 		else {
    	 			pq.add(tmp);
    	 			break;
    	 		}
    	 	}
    	 	res.add(newInterval);
    	 	while(pq.size() > 0)
    	 		res.add(pq.poll());
    	 	return res;
    }
	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
