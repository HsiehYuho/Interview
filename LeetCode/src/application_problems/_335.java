package application_problems;

public class _335 {
	public static void main(String[] args) {
		_335 a = new _335();
		a.exe();
	}
	public void exe() {
		//{1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1}
		System.out.println(isSelfCrossing(new int[] {1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1}));  // {10,6,2,2,1,1} ,{3,3,3,2,1,1}
		return;
	}
	public boolean isSelfCrossing(int[] x) {
		Point[] type1 = new Point[4]; // first type
		type1[0] = new Point(0,0);
		Point[] type2 = new Point[5]; // second type
		type2[0] = new Point(0,0);
		Point[] type3 = new Point[6]; // third type
		type3[0] = new Point(0,0);
		int index1 = 0, index2 = 0, index3 = 0;
		int dirIndex = 0;
		int[][] dir = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
		Point aPoint, bPoint, cPoint, dPoint;
		for(int i : x) {
			//type1 check 
			cPoint = type1[index1];   
			index1 += 1;
			index1 %= 4;
			aPoint = type1[index1];  
			bPoint = type1[(index1+1) % 4];
			dPoint = new Point(cPoint.x+dir[dirIndex][0]*i,cPoint.y+dir[dirIndex][1]*i); 
			type1[index1] = dPoint; // update
			if(VHintersect(aPoint,bPoint,cPoint,dPoint)) {
				System.out.println("type1");
				return true;
			}
			// type2 check
			cPoint = type2[index2];			
			index2 += 1;
			index2 %= 5;
			aPoint = type2[index2];
			bPoint = type2[(index2+1) % 5];
			dPoint = new Point(cPoint.x+dir[dirIndex][0]*i,cPoint.y+dir[dirIndex][1]*i);
			type2[index2] = dPoint; // update
			if(nVHintersect(aPoint,bPoint,cPoint,dPoint)) {
				System.out.println("type2");
				return true;				
			}
			
			// type3 check
			cPoint = type3[index3];
			index3 += 1;
			index3 %= 6;
			aPoint = type3[index3];
			bPoint = type3[(index3+1) % 6];
			dPoint = new Point(cPoint.x+dir[dirIndex][0]*i,cPoint.y+dir[dirIndex][1]*i);
			type3[index3] = dPoint; // update
			if(VHintersect(aPoint,bPoint,cPoint,dPoint)) {
				System.out.println("type3");
				return true;							
			}
			
			dirIndex++;
			dirIndex %= 4;
		}
		return false;
	
	}
	private boolean nVHintersect(Point A, Point B, Point C, Point D) {
		if(A == null || B == null || C == null || D == null)
			return false;
		if(A.x == B.x && A.x == C.x){ // vertical line
			int minAB = Math.min(A.y,B.y), maxAB = Math.max(A.y, B.y);
			int minCD = Math.min(C.y,D.y), maxCD = Math.max(C.y, D.y);
			if((minAB >= minCD && minAB <= maxCD) || (maxAB >= minCD && maxAB <= maxCD)) {
//				System.out.println("vertical");
//				System.out.println("A:" + A.x + " " + A.y);
//				System.out.println("B:" + B.x + " " + B.y);
//				System.out.println("C:" + C.x + " " + C.y);
//				System.out.println("D:" + D.x + " " + D.y);

				return true;
			}
		}
		else if(A.y == B.y && A.y == C.y) { // horizontal line
			int minAB = Math.min(A.x,B.x), maxAB = Math.max(A.x, B.x);
			int minCD = Math.min(C.x,D.x), maxCD = Math.max(C.x, D.x);
			if((minAB >= minCD && minAB <= maxCD) || (maxAB >= minCD && maxAB <= maxCD)) {
//				System.out.println("horizontal");
				return true;
			}
		}
		return false;
	}
	
	private boolean VHintersect (Point A, Point B, Point C, Point D) {
		// AB -> one line , CD -> one line
		if(A == null || B == null || C == null || D == null)
			return false;
		if(A.x == B.x) { // ab vertical line, cd horizontal line
			if((C.x-A.x)*(D.x-A.x) <= 0 && (A.y-C.y) * (B.y-C.y) <= 0)
				return true;
		}
		else {
			if((A.x-C.x)*(B.x-C.x) <= 0 && (C.y-A.y) * (D.y-A.y) <= 0)
				return true;
		}
		return false;
	}
	public class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
