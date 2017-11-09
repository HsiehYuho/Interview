package iterator;

import java.util.Iterator;
import java.util.List;

public class _251 {
	public static void main(String[] args) {
		return;
	}
	public class Vector2D implements Iterator<Integer> {
		List<List<Integer>> vec2d;
		int cur;
		Iterator<Integer> itr;
	    public Vector2D(List<List<Integer>> vec2d) {
	        this.vec2d = vec2d;
	        cur = 0;
	        if(vec2d == null || vec2d.size() == 0)
	        		return;
	        itr = vec2d.get(cur).iterator(); // the cur th iterator
	    }

	    @Override
	    public Integer next() {
	    		if(itr.hasNext())  // update the itr when encounting the end of cur lsit
	    			return itr.next();
	    		else
	    			return null;
	    }

	    @Override
	    public boolean hasNext() {
	        if(itr == null)
	        		return false;
	        if(itr.hasNext())
	        		return true;
	        else {
	        		if(cur == vec2d.size()-1)
	        			return false;
	        		else {
	        			itr = vec2d.get(++cur).iterator();
	        			return hasNext();
	        		}
	        }
	    }
	}
}
