package hashmap_application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _249 {
	public static void main(String[] args) {
		_249 a = new _249();
		a.exe();
	}
	public void exe() {
		String[] strings = new String[] {"a","b","abc","def","yza","ccv"};
		List<List<String>> res = groupStrings(strings);
		for(List<String> list : res) {
			for(String s : list)
				System.out.print(s + " ");
			System.out.println();
		}
		return;
	}
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<>();
		List<String> single = new ArrayList<>();
		HashMap<String,ArrayList<String>> map = new HashMap<>();
		for(int i = 0; i < strings.length; i++) {
			String s = strings[i];
			if(s.length() == 1)
				single.add(s);
			else {
				char[] chars = s.toCharArray();
				char c = chars[0];
				StringBuilder sb = new StringBuilder();
				for(int k = 1; k < chars.length; k++) {
					int dif = c-chars[k];
					if(dif >= 0)
						sb.append(dif);
					else
						sb.append(dif+26);
				}
				String sbString = sb.toString();
				ArrayList<String> list = map.get(sbString);
				if(list == null) {
					list = new ArrayList<>();
					map.put(sbString, list);
				}
				list.add(s);
			}
		}
		if(single.size() != 0)
			res.add(single);
		for(String s : map.keySet()) {
			res.add(map.get(s));
		}
		return res;
    }
}
