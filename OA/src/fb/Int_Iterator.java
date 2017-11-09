package fb;

public class Int_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Int_Iterator sol = new Int_Iterator();
		int[] a1 = new int[] {0,0};
		int[] a2 = new int[] {1,0,0};
		Iter itr1 = new Iter(a1);
		Iter itr2 = new Iter(a2);
		System.out.println(sol.oneOrZeroDif(itr1,itr2));
	}
	private boolean oneOrZeroDif(Iter a1, Iter a2) {
		int m = -1, n = -1;
		while(a1.hasNext() && a2.hasNext()) {
			m = a1.next();
			n = a2.next();
			if(m != n)
				break;
		}
		// scenario 1: both to end, not matter is m == n or m != n
		if(!a1.hasNext() && !a2.hasNext())
			return true;
		// either one of each reach the end, or both not reach end
		if(!a1.hasNext() || !a2.hasNext()) {
			// reach a2.end 
			if(a1.hasNext() && !a2.hasNext()) {
				if(m == n) {
					a1.next();
					return !a1.hasNext();
				}
				else {
					return false;
				}
			}
			// reach a1.end
			else if(!a1.hasNext() && a2.hasNext()) {
				if(m == n) {
					a2.next();
					return !a2.hasNext();
				}
				else
					return false;
			}
			// do not reach either of the end
			else {
				boolean case1 = true, case2 = true, case3 = true;
				// if m != n and the remains are the same
				Iter ptr1 = a1, ptr2 = a2;
				// case1
				while(ptr1.hasNext() || ptr2.hasNext()) {
					if(ptr1.next() != ptr2.next() || !(ptr1.hasNext() && ptr2.hasNext())) {
						case1 = false; 
						break;
					}
				}
				//case2
				if(!case1) {
					ptr1 = a1; 
					ptr2 = a2;
					ptr1.next();
					while(ptr1.hasNext() || ptr2.hasNext()) {
						if(ptr1.next() != ptr2.next() || !(ptr1.hasNext() && ptr2.hasNext())) {
							case2 = false;
							break;
						}
					}					
				}
				//case3
				if(!case1 && !case2) {
					ptr1 = a1; 
					ptr2 = a2;
					ptr2.next();
					while(ptr1.hasNext() || ptr2.hasNext()) {
						if(ptr1.next() != ptr2.next() || !(ptr1.hasNext() && ptr2.hasNext())) {
							case3 = false;
							break;
						}
					}					
				}
				return case1 || case2 || case3;
			}
		}
		return true;
	}
	
	static class Iter {
		int[] a;
		int idx = 0;
		public Iter(int[] a) {
			this.a = a;
		}
		public boolean hasNext() {
			return idx < a.length;
		}
		public int next() {
			return a[idx++];
		}
		
	}

}
