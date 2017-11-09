package fb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Remove_Invalid_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Remove_Invalid_Parentheses sol = new Remove_Invalid_Parentheses();
		sol.exe();
		return;
	}
	private void exe() {
		List<String> ans = removeInvalidParentheses("()))");
		for(String s : ans)				
			System.out.println(s);
	}
	public List<String> removeInvalidParentheses(String s) {
		Queue<String> q = new LinkedList<>();
		HashSet<String> visit = new HashSet<>();
		List<String> ans = new ArrayList<>();
		q.offer(s);
		visit.add(s);
		boolean found = false;
		while(q.size() != 0) {
			String cur = q.poll();
			if(isValid(cur)) {
				found = true;
				ans.add(cur);
			}
			if(found)
				continue;
			for(int i = 0; i < cur.length(); i++) {
				if(cur.charAt(i) != '(' && cur.charAt(i) != ')') 
					continue;
				String news = cur.substring(0,i) + cur.substring(i+1);
//				System.out.println(news);
				if(!visit.contains(news)) {
					q.offer(news);
					visit.add(news);	
				}
			}	
		}
		return ans;
	}
	private boolean isValid(String s) {
		int count = 0;
		for(char c : s.toCharArray()) {
			if(c == '(')
				count++;
			if(c ==')')
				count--;
			if(count < 0)
				return false;
		}
		return count == 0;
	}

}
