package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Group_Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}

	// using an encoding way to store string
	// using a hashmap to key the encoding value to the exact arraylist
	public ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
		Map<String, ArrayList<String>> map = new HashMap<>();
		for(String s : strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars); // kind of important encoding way
			if(!map.containsKey(key))
				map.put(key, new ArrayList<String>());
			map.get(key).add(s);
//			list.add(s);
//			map.put(s,list); pass by reference 
		}
		return new ArrayList<ArrayList<String>>(map.values()); // we only use map.keyset, but seems value if better 
	}
}
