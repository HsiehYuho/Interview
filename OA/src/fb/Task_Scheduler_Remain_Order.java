package fb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task_Scheduler_Remain_Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task_Scheduler_Remain_Order a = new Task_Scheduler_Remain_Order();
		a.exe();
	}
	private void exe() {
		char[] task = new char[]{'a','a','b','a','a','a','b','a'};
		List<Character> ans = schedule(task,2);
		for(char c : ans)
			System.out.print(c+" ");
		return;
	}
	public List<Character> schedule(char[] tasks, int k){
		HashMap<Character, Integer> map = new HashMap<>(); // character and current time
		List<Character> ans = new ArrayList<>();
		int time = 0;
		for(char c : tasks) {
			while(map.containsKey(c) && (time - map.get(c) <= k)) {
				ans.add('i');
				time++;
			}
			map.put(c, time++);
			ans.add(c);
		}
		return ans;
	}
	
	

}
