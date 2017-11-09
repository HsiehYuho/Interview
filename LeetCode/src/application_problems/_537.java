package application_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _537 {
	public static void main(String[] args) {
		_537 a = new _537();
		a.exe();
	}
	public void exe() {
		int[][] ps = new int[][] {{1,1},{2,2},{2,0},{2,4},{3,3},{4,2}};
		Point[] points = new Point[ps.length];
		int i = 0;
		for(int[] p : ps)
			points[i++] = new Point(p[0],p[1]);
		List<Point> list = outerTrees(points);
		for(Point p : list)
			System.out.println(p.x + " " + p.y);
		return;
	}
	public class Point {
	     int x;
	     int y;
	     Point() { x = 0; y = 0; }
	     Point(int a, int b) { x = a; y = b; }
	}
    public List<Point> outerTrees(Point[] points) {
        if(points.length <= 1)
        		return Arrays.asList(points);
        Stack<Point> stack = new Stack<>();
        Point reference = findLeftBottom(points);
        sortByPolar(points,reference);
        stack.push(points[0]);
        stack.push(points[1]);
        for(int i = 2; i < points.length; i++) {
        		Point p = stack.pop();  
        		while(ccw(stack.peek(),p,points[i]) < 0)  // at first iteration, stack.peek() is reference
        			p = stack.pop(); // pop out top valid candidate
        		stack.push(p);
        		stack.push(points[i]);
        }
        return new ArrayList<>(stack);
    }
    private Point findLeftBottom(Point[] points) {
    		Point bf = points[0];
    		for(Point p : points) {
    			if(p.y < bf.y || (p.y == bf.y && p.x < bf.x))
    				bf = p;
    		}
    		return bf;
    }
    // positive => ccw , negative => cw, 0 => conlinear
    private int ccw(Point a, Point b, Point c) {
    		return a.x*b.y - a.y*b.x + b.x*c.y-b.y*c.x + c.x*a.y-c.y*a.x; 
    }
    // return the square of distance of point a, b
    private int dist(Point a, Point b) {
    		return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y);
    }
    private void sortByPolar(Point[] points, Point reference) {
    	// most important part!!
    		Arrays.sort(points,(p,q) -> {
    			int comPor = ccw(p,reference,q);
    			int comDis = dist(p,reference) - dist(q,reference);
    			return comPor == 0 ? comDis : comPor;
    		});
    		System.out.println("/// sorting ///");
    		for(Point p : points)
    			System.out.println(p.x + " " + p.y);
    		System.out.println("/// sorting ///");

    		// find the end of the points 
    		Point p = points[0];
    		Point q = points[points.length-1];
    		int idx = points.length-2;
    		while(idx >= 0 && ccw(p,q,points[idx]) == 0) {
    			idx--;
    		}
    		// reverse the end points
    		for(int i = idx+1, j = points.length-1; i < j; i++, j--) {
    			Point tmp = points[i];
    			points[i] = points[j];
    			points[j] = tmp;
    		}
    		return;
    }
}
