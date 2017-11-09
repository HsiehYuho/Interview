package application_problems;

import java.util.HashSet;

public class _391 {
	public static void main(String[] args) {
		_391 a = new _391();
		a.exe();
	}
	public void exe() {
	}
	public boolean isRectangleCover(int[][] rectangles) {
		HashSet<String> set = new HashSet<>();
		int x1 = Integer.MAX_VALUE;
		int y1 = Integer.MAX_VALUE;
		int x2 = Integer.MIN_VALUE;
		int y2 = Integer.MIN_VALUE;
		int area = 0;
		for(int[] i : rectangles) {
			String point1 = i[0] + " " + i[1];
			String point2 = i[0] + " " + i[3];
			String point3 = i[2] + " " + i[1];
			String point4 = i[2] + " " + i[3];
			x1 = Math.min(i[0], x1);
			y1 = Math.min(i[1], y1);
			x2 = Math.max(i[2], x2);
			y2 = Math.max(i[3], y2);
			area += (i[2] - i[0]) * (i[3] - i[1]);
			if(!set.add(point1)) set.remove(point1);
			if(!set.add(point2)) set.remove(point2);
			if(!set.add(point3)) set.remove(point3);
			if(!set.add(point4)) set.remove(point4);
		}
		if(set.size() != 4 || !set.contains(x1+" "+y1) || !set.contains(x1+" "+y2) || !set.contains(x2+" "+y1) || !set.contains(x2+" "+y2))
				return false;
		return area == (x2-x1) * (y2-y1);
    }
}
