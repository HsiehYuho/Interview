package fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Random_Pop_Linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random_Pop_Linkedlist sol = new Random_Pop_Linkedlist();
		sol.exe();
	}
	public void exe() {
		LinkedList<Integer> q= new LinkedList<>();
		q.add(1);
		q.add(3);
		q.add(3);
		q.add(7);
		int[] res = collect(q);
		for(int i : res)
			System.out.print(i + " ");
	}
	private int[] collect(LinkedList<Integer> q) {
		List<Integer> desc = new ArrayList<>();
		List<Integer> asc = new ArrayList<>();
		while(q.size() != 0) {
			int cur = randPop(q);
			if(desc.isEmpty() && asc.isEmpty()) {
				desc.add(cur);
				asc.add(cur);
			}
			else {
				if(asc.get(asc.size()-1) < cur) {
					desc.remove(desc.size()-1);
				}
				else {
					asc.remove(asc.size()-1);
				}
				if(q.size() != 0) {
					asc.add(cur);
					desc.add(cur);					
				}
				else
					asc.add(cur);
			}
		}
		int[] array = new int[desc.size() + asc.size()];
		int idx = 0;
		for(; idx < asc.size(); idx++)
			array[idx] = asc.get(idx);
		for(int j = desc.size()-1; j >= 0; j--,idx++)
			array[idx] = desc.get(j);
		return array;
	}
	private int randPop(LinkedList<Integer> q) {
		Random rand = new Random();
		if(rand.nextInt(2) == 0)
			return q.remove(0);
		else
			return q.remove(q.size()-1);
	}

}
