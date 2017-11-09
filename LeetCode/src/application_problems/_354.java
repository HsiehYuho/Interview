package application_problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _354 {
	public static void main(String[] args) {
		_354 a = new _354();
		a.exe();
	}
	public void exe() {
		int[][] envelopes = new int[][]{{1,2},{2,3},{3,4},{3,5},{4,5},{5,5},{5,6},{6,7},{7,8}};
		System.out.println(maxEnvelopes(envelopes));
		return;
	}
	public int maxEnvelopes(int[][] envelopes) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]== b[0]? b[1]-a[1] : a[0]-b[0]));
        for(int[] i : envelopes)
        		pq.add(i);
        ArrayList<Integer> list = new ArrayList<>();
        while(pq.size() != 0) {
        		int[] envelope = pq.poll();
        		if(list.size() == 0 || list.get(list.size()-1) < envelope[1]) {
        			list.add(envelope[1]);        				
        		}
        		else {
        			int left = 0, right = list.size()-1;
        			while(left < right) {
        				int mid = (left + right) / 2;
        				if(envelope[1] <= list.get(mid))
        					right = mid;
        				else
        					left = mid+1;
	            	}
        			list.set(right, envelope[1]);
        		}
        }
        return list.size();
    	}
}
