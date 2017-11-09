package pointer;

import java.util.ArrayList;

public class _243 {
    public static void main(String[] args) {
    		_243 a = new _243();
    		a.exe();
    }
    public void exe() {
    		String[] words = new String[] {"practice", "makes", "perfect", "coding", "makes"};
    		System.out.println(shortestDistance(words,"makes","coding"));
    }
	
	public int shortestDistance(String[] words, String word1, String word2) {
        ArrayList<Integer> ad1 = new ArrayList<>();
        ArrayList<Integer> ad2 = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
        		if(words[i].equals(word1))
        			ad1.add(i);
        		if(words[i].equals(word2))
        			ad2.add(i);
        }
        int dis = Integer.MAX_VALUE;
        int ptr1 = 0, ptr2 = 0;
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
