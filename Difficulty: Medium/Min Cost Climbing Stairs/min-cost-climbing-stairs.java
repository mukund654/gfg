//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        for(int i = cost.length-3;i>=0;i--){
            cost[i] = Math.min(cost[i]+cost[i+1], cost[i]+cost[i+2]);
        }
        return Math.min(cost[0],cost[1]);
    }
};