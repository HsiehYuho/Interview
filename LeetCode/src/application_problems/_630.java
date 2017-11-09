package application_problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _630 {
	public static void main(String[] args) {
		_630 a = new _630();
		a.exe();
	}
	public void exe() {
		int[][] courses = new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
		System.out.println(scheduleCourse(courses));
		return;
	}
	public int scheduleCourse(int[][] courses) { // [duration, ending time]
		Arrays.sort(courses,(a,b)->(a[1]-b[1]));
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));
		int init = 0;
		for(int[] course : courses) {
			init += course[0];
			pq.add(course[0]);
			if(init > course[1])
				init -= pq.poll();
		}
		return pq.size();
    }
}
