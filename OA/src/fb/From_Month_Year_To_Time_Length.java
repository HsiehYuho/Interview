package fb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class From_Month_Year_To_Time_Length {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		From_Month_Year_To_Time_Length obj = new From_Month_Year_To_Time_Length();
		obj.exe();
	}
	public void exe() {
		String[] s = new String[] {"Apr2010 - Mar2011", "Jan2010 -Feb2010" };
		System.out.println(transform(s));
		return;
	}
	public int transform(String[] s) {
		List<Interval> intervals = new ArrayList<>();
		// deal with string
		for(int i = 0; i < s.length; i++) {
			int[] date = dateToInteger(s[i]);
			intervals.add(new Interval(date[0],date[1]));
		}
		// sort the intervals
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				if(a.start == b.start)
					return b.end - a.end;
				return a.start - b.start;
			}
		});
		// merge the intervals
		List<Interval> res = new ArrayList<>();
		for(int i = 0; i < intervals.size(); i++) {
			if(i < intervals.size() -1) {
				Interval cur = intervals.get(i);
				Interval next = intervals.get(i+1);
				if(cur.end < next.start)
					res.add(cur);
				else {
					Interval newInterval = new Interval(cur.start,Math.max(cur.end, next.end));
					intervals.set(i+1, newInterval);
				}
			}
			else
				res.add(intervals.get(i));
		}
		// compute the overlap time
		int sum = 0;
		for(int i = 0; i < res.size(); i++) {
			Interval cur = res.get(i);
			sum += (cur.end-cur.start);
		}
		return sum;
	}
	private class Interval{
		int start;
		int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	// s = Apr 2010 - Dec 2010
	private int[] dateToInteger(String s) {
		s = s.replace(" ", "");
		String[] dates = s.split("-");
		int month_start = monthToInteger(dates[0].substring(0,3));
		int month_end = monthToInteger(dates[1].substring(0,3));
		int year_start = Integer.valueOf(dates[0].substring(3)) * 12;
		int year_end = Integer.valueOf(dates[1].substring(3)) * 12;
		return new int[] {month_start+year_start,month_end+year_end};
		
	}
	private int monthToInteger(String s) {
		if(s.equals("Jan"))
			return 1;
		if(s.equals("Feb"))
			return 2;
		if(s.equals("Mar"))
			return 3;
		if(s.equals("Apr"))
			return 4;
		if(s.equals("Fri"))
			return 5;
		if(s.equals("Jun"))
			return 6;
		if(s.equals("Jul"))
			return 7;
		if(s.equals("Aug"))
			return 8;
		if(s.equals("Sep"))
			return 9;
		if(s.equals("Oct"))
			return 10;
		if(s.equals("Nov"))
			return 11;
		if(s.equals("Dec"))
			return 12;
		return -1;
	}

}
