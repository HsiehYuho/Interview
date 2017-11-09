package fb;

import java.util.PriorityQueue;

public class Next_Biggest_Task_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Next_Biggest_Task_Iterator sol = new Next_Biggest_Task_Iterator();
		sol.exe();
	}
	private void exe() {
		int[][] tasks= new int[][] {{5,4,3},{10,9,1,1},{8,2}};
		Itr itr = new Itr(tasks);
		while(itr.hasNext())
			System.out.println(itr.next());
		return;
	}
	private class Itr{
		PriorityQueue<int[]> pq;
		int[][] tasks;
		public Itr(int[][] tasks) {
			this.tasks = tasks;
			pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
			for(int i = 0; i < tasks.length; i++) {
				pq.add(new int[] {tasks[i][0],i,0});
			}
		}
		private int next() {
			int[] task = pq.remove();
			int idx = task[1];
			int ele = task[2] + 1;
			if(ele < tasks[idx].length)
				pq.add(new int[] {tasks[idx][ele],idx,ele});
			else
				System.out.println("array idx: " + idx + " used up");
			return task[0];
		}
		private boolean hasNext() {
			return pq.size() != 0;
		}
	}
	

}
