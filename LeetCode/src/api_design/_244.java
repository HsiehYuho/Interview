package api_design;

import java.util.ArrayList;
import java.util.HashMap;

public class _244 {
    public static void main(String[] args) {
    		_244 a = new _244();
    		a.exe();
    }
    public void exe() {
    		String[] words = new String[] {"practice", "makes", "perfect", "coding", "makes"};
    		WordDistance(words);
    		System.out.println(shortest("makes","coding"));
    		return;
    }
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
	public void WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++) {
        		ArrayList<Integer> list = map.get(words[i]);
        		if(list == null) {
        			list = new ArrayList<>();
        		}
        		list.add(i);
        		map.put(words[i], list);
        }
    }
    public int shortest(String word1, String word2) {
    		ArrayList<Integer> ad1 = map.get(word1);
    		ArrayList<Integer> ad2 = map.get(word2);
    		int ptr1 = 0, ptr2 = 0;
    		int dis = Integer.MAX_VALUE;
        while(ptr1 < ad1.size() && ptr2 < ad2.size()) {
        		int tmpDis = (ad1.get(ptr1) - ad2.get(ptr2));
        		if(tmpDis < 0)
        			ptr1++;
        		else
        			ptr2++;
        		dis = Math.min(Math.abs(tmpDis), dis);
        }
        if(ptr1 == ad1.size()) {
        		while(ptr2 < ad2.size()) {
            		int tmpDis = Math.abs(ad2.get(ptr2++) - ad1.get(ptr1-1));
            		dis = Math.min(tmpDis, dis);        			
        		}
        }
        else {
        		while(ptr1 < ad1.size()) {
        			int tmpDis = Math.abs(ad1.get(ptr1++) - ad2.get(ptr2-1));
        			dis = Math.min(tmpDis, dis);        			
        		}
        }
        return dis;
    }
}
