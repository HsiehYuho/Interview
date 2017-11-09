package iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _281 {
	public static void main(String[] args) {
		_281 a = new _281();
		a.exe();
	}
	public void exe() {
		return;
	}
	Queue<Iterator<Integer>> q;
	public void ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		q = new LinkedList<>();
		if(v1.size() != 0)
			q.add(v1.iterator());
        if(v2.size() != 0)
    			q.add(v2.iterator());
    }
    public int next() {
    		Iterator<Integer> itr = q.remove();
    		int ans = itr.next();
    		if(itr.hasNext())
    			q.add(itr);
    		return ans;
    }

    public boolean hasNext() {
    		return q.size() != 0;
        
    }
}
