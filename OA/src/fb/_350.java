package fb;

import java.util.ArrayList;
import java.util.HashMap;

public class _350 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}
	// there are some follow-up relating to 
	/*
	 * If only nums2 cannot fit in memory, put all elements of 
	 * nums1 into a HashMap, read chunks of array that fit into the memory, 
	 * and record the intersections. If both nums1 and nums2 are so huge 
	 * that neither fit into the memory, sort them individually (external sort), 
	 * then read 2 elements from each array at a time in memory, record intersections.
	 */
    public int[] intersect(int[] nums1, int[] nums2) {
    		HashMap<Integer,Integer> map = new HashMap<>();
    		ArrayList<Integer> list = new ArrayList<>();
    		for(int i : nums1) {
    			map.put(i,map.getOrDefault(i, 0)+1);
    		}
    		for(int i : nums2) {
    			if(map.containsKey(i)) {
    				list.add(i);
    				int tmp = map.get(i);
    				if(tmp == 1)
    					map.remove(i);
    				else
    					map.put(i, tmp-1);
    			}    				
    		}
    		int[] res = new int[list.size()];
    		int idx = 0;
    		for(int i : list)
    			res[idx++] = i;
    		return res;
    }
    
}
