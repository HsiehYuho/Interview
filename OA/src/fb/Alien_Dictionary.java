package fb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Alien_Dictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alien_Dictionary a = new Alien_Dictionary();
		a.exe();
	}
	public void exe() {
		return;
	}
	// using a hashmap to record all character after certain c by hashset
	// using another hashmap to record how many character are before certain character
	public String alienOrder(String[] words) {
		HashMap<Character,HashSet<Character>> map = new HashMap<>();
		HashMap<Character,Integer> degree = new HashMap<>();
		// initialize the degree part 
		for(String word : words) {
			for(Character c : word.toCharArray()) {
				if(!degree.containsKey(c))
					degree.put(c, 0);
			}
		}
		// start to put the word one by one into degree and map
		for(int i = 0; i < words.length-1; i++) {
			String cur = words[i];
			String next = words[i+1];
			for(int j = 0; j < Math.min(cur.length(), next.length()); j++) {
				char curC = cur.charAt(j);
				char nextC = next.charAt(j);
				if(curC != nextC) {
					HashSet<Character> set = map.containsKey(curC) ? map.get(curC) : new HashSet<>();
					// we need to check that, the degree should only increase once!!!!
					if(!set.contains(nextC)) {
						set.add(nextC); // curC has more character after it
						degree.put(nextC, degree.get(nextC)+1); // record the number of it ascendant
						map.put(curC, set);
					}
					break; // no matter what, break after meet same character
				}
			}
		}
		// start to do the topological sort using a queue
		Queue<Character> q = new LinkedList<>();
		for(char c : degree.keySet()) {
			if(degree.get(c) == 0) {
				q.add(c);
			}
		}
		// to get the set of Character after c, then reduce there degree
		String res = "";
		while(q.size() != 0) {
			char c = q.poll();
			res = res + c;
			if(map.containsKey(c)) { // for those only appear one times !! remember to check map.containsKey before using every map.get
				for(char afterC : map.get(c)) {
					if(degree.get(afterC) == 1)
						q.add(afterC);
					else
						degree.put(afterC, degree.get(afterC)-1);
				
				}
			}
		}
		if(res.length() != degree.size())
			return "";
		return res;
	}

}
