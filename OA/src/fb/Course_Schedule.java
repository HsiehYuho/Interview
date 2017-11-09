package fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Course_Schedule sol = new Course_Schedule();
		sol.exe();
	}
	private void exe() {
		int[][] request = new int[][] {{0,1},{1,4},{2,3},{3,2}};
		int n = 5;
		List<Integer> order = scheduleCourse(n,request);
		if(order.size() == 0)
			System.out.println("cannot complete");
		for(int i : order)
			System.out.print(i + " ");
		return;
	}
	// build up the inbound array 
	// add the request to each course
	private List<Integer> scheduleCourse(int n, int[][] request) {
		int[] inBound = new int[n];
		List<List<Integer>> req = new ArrayList<>();
		for(int i = 0; i < n; i++)
			req.add(new ArrayList<>());
		build(inBound,req,request);
		return evaluate(inBound,req);
	}
	private void build(int[] inBound, List<List<Integer>> req, int[][] request) {
		for(int[] r : request) {
			inBound[r[1]]++;
			req.get(r[0]).add(r[1]);
		}
	}
	private List<Integer> evaluate(int[] inBound, List<List<Integer>> req) {
		int n = inBound.length;
		List<Integer> order = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i = 0; i < n; i++) {
			if(inBound[i] == 0)
				q.add(i);
		}
		while(q.size() != 0) {
			int course = q.remove();
			order.add(course);
			List<Integer> finish = req.get(course);
			for(int nextCourse : finish) {
				inBound[nextCourse]--;
				if(inBound[nextCourse] == 0)
					q.add(nextCourse);
			}
		}
		if(order.size() != n)
			return new ArrayList<>();
		return order;
	}
	

}
