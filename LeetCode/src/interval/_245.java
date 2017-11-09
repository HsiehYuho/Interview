package interval;

import java.util.ArrayList;
import java.util.HashMap;

public class _245 {
	public static void main(String[] args) {
		_245 a = new _245();
		a.exe();
	}
	public void exe() {
		String[] words = new String[] {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(shortestWordDistance(words,"makes","makes"));
		return;
	}
	public int shortestWordDistance(String[] words, String word1, String word2) {
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0; i < words.length; i++) {
			ArrayList<Integer> list = map.get(words[i]);
			if(list == null)
				list = new ArrayList<>();
			list.add(i);
			map.put(words[i], list);
		}
		int minDis = Integer.MAX_VALUE;
		if(word1.equals(word2)) {
			ArrayList<Integer> list = map.get(word1);
			for(int i = 1; i < list.size(); i++) {
				minDis = Math.min(minDis, list.get(i) - list.get(i-1));
			}
		}
		else {
			ArrayList<Integer> list1 = map.get(word1);
			ArrayList<Integer> list2 = map.get(word2);
			int ptr1 = 0, ptr2 = 0;
			while(ptr1 < list1.size() && ptr2 < list2.size()) {
				int tmpDis = list1.get(ptr1) - list2.get(ptr2);
				if(tmpDis < 0)
					ptr1++;
				else
					ptr2++;
				minDis = Math.min(minDis, Math.abs(tmpDis));
			}
			if(ptr1 == list1.size()) {
				while(ptr2 < list2.size()) {
					minDis = Math.min(minDis, Math.abs(list2.get(ptr2++)-list1.get(ptr1-1)));
				}
			}
			else {
				while(ptr1 < list1.size()) {
					minDis = Math.min(minDis, Math.abs(list1.get(ptr1++)-list2.get(ptr2-1)));
				}
			}
			
		}
		return minDis;
    }
	
}
