package fb;

import java.util.LinkedList;
import java.util.Queue;

public class Find_The_Well {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Find_The_Well sol = new Find_The_Well();
		sol.exe();
	}
	private void exe() {
		char[][] map = {{'H','T','-'},
						{'-','H','H'},
						{'-','-','-'}};
		System.out.println(findWell(map));
		return;
	}
	private int min 	=Integer.MAX_VALUE;
	private int findWell(char[][] map) {
		int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
		int m = map.length;
		int n = map[0].length;
		int[][] record = new int[m][n];
		int[][] howMany = new int[m][n];
		int house = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 'H') {
					house++;
					bfs(map,record,i,j,dirs,howMany);
				}
			}
		}
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == '-' && howMany[i][j] == house)
					min = Math.min(record[i][j],min);
			}
		}
		for(int[] rs : record) {
			for(int r : rs)
				System.out.print(r + " ");
			System.out.println();
		}
		
		return min;
	}
	private void bfs(char[][] map, int[][] record, int i, int j, int[][] dirs, int[][] howMany) {
		int m = map.length, n = map[0].length;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		q.offer(new int[]{i,j});
		int level = 0;
		while(q.size() != 0) {
			int size = q.size();
			for(int k = 0; k < size; k++) {
				int[] cur = q.poll();
				if(visited[cur[0]][cur[1]])
					continue;
				visited[cur[0]][cur[1]] = true;
				howMany[cur[0]][cur[1]]++;
				record[cur[0]][cur[1]] += level;
				for(int[] dir : dirs) {
					int x = cur[0] + dir[0];
					int y = cur[1] + dir[1];
					if(x >= 0 && x < m && y >= 0 && y < n) {
						if(map[x][y] == '-' && !visited[x][y])
							q.add(new int[] {x,y});
					}
				}
			}
			level++;
		}
	}

}
