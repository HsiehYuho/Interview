package api_design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class _352 {
	public static void main(String[] args) {
		_352 a = new _352();
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
	public class SummaryRanges {
		/** Initialize your data structure here. */
		TreeMap<Integer,Interval> map;
		public SummaryRanges() {
			map = new TreeMap<>();
		}   
		public void addNum(int val) { // store the start point as key
			if(map.containsKey(val))
				return;
			Integer l = map.lowerKey(val); // return the greatest key that is lower than val !!
			Integer h = map.higherKey(val); // return the lowest key that is greater than val !!
			//connect two disjoint set, val lies in the middle of two sets
			if(l != null && h != null && map.get(l).end+1 == val && val+1 == map.get(h).start) {
				map.get(l).end = map.get(h).end;
				map.remove(h);
			}
			// connect the lower set, due to the val is higher than l.end
			else if(l != null && map.get(l).end+1 >= val)
				map.get(l).end = Math.max(map.get(l).end, val);
			// connect the higher set, due to the val is lower than h.start
			else if(h != null && map.get(h).start -1 == val) {
				map.put(val,new Interval(val,map.get(h).end));
				map.remove(h);
			}
			// does not touch any point
			else
				map.put(val, new Interval(val,val));
		}		    
		public List<Interval> getIntervals() {
			return new ArrayList<Interval>(map.values());
		}
	}
}
