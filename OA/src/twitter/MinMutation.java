package twitter;

import java.util.HashSet;

public class MinMutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minMutation(String start, String end, String[] bank) {
        char[] gene = new char[]{'A','T','C','G'};
        if(bank == null || bank.length == 0)
            return -1;
        HashSet<String> dic = new HashSet<>();
        for(String s : bank)
            dic.add(s);
        if(!dic.contains(end))
            return -1;
        HashSet<String> from = new HashSet<>();
        HashSet<String> to = new HashSet<>();
        HashSet<String> visit = new HashSet<>();
        from.add(start);
        to.add(end);
        visit.add(start);
        visit.add(end);
        int count = 0;
        while(to.size() != 0 && from.size() != 0){
            if(from.size() > to.size()){
                HashSet<String> tmp = new HashSet<>();
                tmp = to;
                to = from;
                from = tmp;
            }
            HashSet<String> tmp = new HashSet<>();
            for(String s : from){
                char[] chars = s.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    char old = chars[i];
                    for(char c : gene){
                        if(c == old)
                            continue;
                        chars[i] = c;
                        String candidate = String.valueOf(chars);
                        if(to.contains(candidate))
                            return count + 1;
                        if(dic.contains(candidate) && !visit.contains(candidate)){
                            tmp.add(candidate);
                            visit.add(candidate);
                        }
                    }
                    chars[i] = old;
                }
            }
            from = tmp;
            count++;
        }  
        return -1;
	}
}
