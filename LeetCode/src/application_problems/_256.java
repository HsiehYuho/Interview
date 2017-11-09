package application_problems;

public class _256 {
	public static void main(String[] args) {
		_256 a = new _256();
		a.exe();
	}
	public void exe() {
		int[][] costs = new int[][] {{1,5,3,6},{2,3,1,6},{2,7,8,9},{1,1,2,3}};
		System.out.println(minCost(costs));
		return;
	}
    public int minCost(int[][] costs) {
    		if(costs == null || costs.length == 0)
    			return 0;
    		int n = costs.length-1;
    		for(int i = 1; i < costs.length; i++) {
    			costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
    			costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
    			costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
    		}
    		return Math.min(costs[n][0],Math.min(costs[n][1], costs[n][2]));
    }
}
/*
    public int minCost(int[][] costs) {
   		if(costs.length == 0)
    			return 0;
    		return dfs(costs,0,-1);
    }
    private int dfs(int[][] costs, int start, int pre) {
    		if(start == costs.length)
    			return 0;
    		int color0 = costs[start][0] + dfs(costs,start+1,0);
    		int color1 = costs[start][1] + dfs(costs,start+1,1);
    		int color2 = costs[start][2] + dfs(costs,start+1,2);
    		if(pre == 0)
    			return Math.min(color1, color2);
    		if(pre == 1)
    			return Math.min(color0, color2);
    		if(pre == 2)
    			return Math.min(color0, color1);
    		else
    			return Math.min(color0, Math.min(color1, color2));      
    }*/
