package permutation;

import java.util.ArrayList;
import java.util.List;

public class _320 {
	public static void main(String[] args) {
		_320 a = new _320();
		a.exe();
	}
	public void exe() {
		List<String> list = generateAbbreviations("word");
		for(String s : list)
			System.out.println(s);
		return;
	}
    public List<String> generateAbbreviations(String word) {
    		List<String> list = new ArrayList<>();
    		permute(list,word,"",0,0);
    		return list;
    }
    private void permute(List<String> res, String word, String curAns, int count, int index) {
    		if(word.length() == index) {
    			if(count > 0)
    				res.add(curAns+count);
    			else
    				res.add(curAns);
    			return;
    		}
    		// keep it
    		permute(res,word,curAns+ (count > 0 ? count : "") + word.charAt(index),0,index+1);
    		// abbreviate it
    		permute(res,word,curAns,count+1,index+1);
    		
    }
}
