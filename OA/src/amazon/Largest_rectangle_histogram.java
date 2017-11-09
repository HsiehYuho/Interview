package amazon;

public class Largest_rectangle_histogram {
	public static void main(String[] args) {
		Largest_rectangle_histogram a = new Largest_rectangle_histogram();
		a.exe();
	}
	public void exe() {
		return;
	}
	// the most important part is to remember divide and conquer
	public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0)
            return 0;
		return maxArea(heights,0,heights.length-1);
	}
	private int maxArea(int[] heights, int left, int right) {
		if(left == right)
			return heights[left];
		int m = left + (right - left) / 2;
		int leftArea = maxArea(heights,left,m);
		int rightArea = maxArea(heights,m+1,right);
		int midArea = combineArea(heights,left,right,m);
		return Math.max(leftArea, Math.max(rightArea, midArea));
	}
	// the smallest area may also appear across the mid point
	private int combineArea(int[] heights, int start, int end,int mid) {
		if(start == end)
			return heights[start];
		int i = mid, j = mid+1;
		int h = Math.min(heights[i], heights[j]);
		int area = 0;
		while( i >= start && j <= end) {
			h = Math.min(h, Math.min(heights[i],heights[j]));
			area = Math.max((j-i+1)*h,area);
			if(i == start)
				j++;
			else if (j == end)
				i--;
			else {
				if(heights[i-1] > heights[j+1]) // if both are < boundary, expand to bigger side
					i--;
				else
					j++;
			}
		}
		return area;
	}
	// another stack solution, keep the height inside the stack increasing!!
	/*
	 Stack<Integer> s = new Stack<>(); // use the stack to store the left, right index
        int i = 0, n = heights.length;
        int maxArea = 0;
        while(i < n){
            while(!s.empty() && heights[i] < heights[s.peek()]){
                int curMaxArea = heights[s.pop()] * (i - (s.empty() ? 0 : (s.peek()+1))); // i=rights.peek()=left
                maxArea = Math.max(maxArea,curMaxArea);
            }
            s.push(i++);
        }
        while(!s.empty()){
            maxArea = Math.max(maxArea,heights[s.pop()] * (i - (s.empty() ? 0 : (s.peek()+1)))); 
        }
        return maxArea;
	 */
}

