package arithmetic;
import java.util.ArrayList;
import java.util.List;

public class _282 {
	public static void main(String[] args){
		_282 a = new _282();
		a.execute();
	}	
	public void execute() {
		System.out.println(addOperators("00",0));
	}
	public List<String> addOperators(String num, int target) {
		List<String> res = new ArrayList<>();
		compute(res,num,target,"",0,0,0);
		return res;
	}
	private void compute(List<String> res, String num, int target, String ans,int index, long output, long pre){
		if(index == num.length()){
			if(output == target)
				res.add(ans);
			return;
		}
		for(int i = index; i < num.length(); i++){
			if(i != index && num.charAt(index) == '0')
				break;
			else {
				Long cur = Long.parseLong(num.substring(index,i+1));
				if(index == 0)
					compute(res,num,target,cur+"",i+1,cur,cur);
				else {
					compute(res,num,target,ans + "+" + cur,i+1,output+cur,cur);
					compute(res,num,target,ans + "-" + cur,i+1,output-cur,-cur);
					compute(res,num,target,ans + "*" + cur,i+1,output-pre+pre*cur,pre*cur);
				}
			}
		}
	}
}
