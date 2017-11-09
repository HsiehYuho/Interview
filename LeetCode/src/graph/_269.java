package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _269 {
	public static void main(String[] args) {
		_269 a = new _269();
		a.exe();
	}
	public void exe() {
		return;
	}
    public String alienOrder(String[] words) {
    		HashMap<Character,HashSet<Character>> map = new HashMap<>();
    		HashMap<Character, Integer> degree = new HashMap<>();
    		String res = "";
    		if(words == null || words.length == 0)
    			return res;
    		// initialize the degree
    		for(String s : words) {
    			for(char c : s.toCharArray()) {
    				degree.put(c, 0);
    			}
    		}
    		// compare the adjacent words to get the immediately order
    		for(int i = 0; i < words.length-1; i++) {
    			String cur = words[i];
    			String next = words[i+1];
    			for(int w = 0; w < Math.min(cur.length(), next.length()); w++) {
    				char c1 = cur.charAt(w);
    				char c2 = next.charAt(w);
    				if(c1 != c2) {
    					HashSet<Character> set = map.containsKey(c1) ? map.get(c1) : new HashSet<>();
    					if(!set.contains(c2)) {
    						set.add(c2);
        					map.put(c1, set);
        					degree.put(c2, degree.get(c2)+1);
    					}
    					break;
    				}
    			}
    		}
    		// start to build the topological sort
    		Queue<Character> q = new LinkedList<Character>();
    		for(Character c : degree.keySet()) {
    			if(degree.get(c) == 0)
    				q.add(c);
    		}	
    		while(q.size()!=0) {
    			char c = q.remove();
    			if(map.containsKey(c)) {
    				for(Character afterC : map.get(c)) {
        				int degreeNum = degree.get(afterC);
        				if(degreeNum == 1)
        					q.add(afterC);
        				else
        					degree.put(afterC, degreeNum-1);    					
    				}
    			}	
    			res += c; 
    		}
    		if(res.length() != degree.size())
    			return "";
    		return res;
		
    	}
	
}
