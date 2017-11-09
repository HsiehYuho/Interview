package fb;

import java.util.HashSet;
import java.util.List;

public class Word_Ladder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		return;
	}	
	// bfs, neighbors, visited or not visited
	// double linked bfs
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> dic = new HashSet<>();
		for(String s : wordList)
			dic.add(s);
		HashSet<String> begin = new HashSet<>();
		HashSet<String> end = new HashSet<>();
		HashSet<String> visited = new HashSet<>();
        if(!dic.contains(endWord))
		    return 0;
        begin.add(beginWord);
		end.add(endWord);
		int len = 1;
		while(!begin.isEmpty() && !end.isEmpty()) {
			if(begin.size() > end.size()) {
				HashSet<String> tmp = begin;
				begin = end;
				end = tmp;
			}
			HashSet<String> tmp = new HashSet<>();
			for(String s : begin) {
				char[] chars = s.toCharArray();
				for(int i = 0; i < chars.length; i++) {
					for(char c = 'a'; c <= 'z'; c++) {
						char old = chars[i];
						chars[i] = c;
						String target = String.valueOf(chars);
						if(end.contains(target) )
							return len+1;
						if(dic.contains(target) && !visited.contains(target)) {
							tmp.add(target);
							visited.add(target);
						}
						chars[i] = old;

					}
				}
			}
			begin = tmp;
			len++;
		}
		return 0;
	}
	

}
