class Solution {
    int minCost(int[] height) {
        // code here
        if(height.length==1){
            return 0;
        }
        if(height.length==2){
            
            return Math.abs(height[0]-height[1]);
        }
        int n = height.length;
        int i1  = Math.abs(height[n-1]-height[n-2]);
        int i2 = 0;
        for(int i = n-3;i>=0;i--){
            int curr = Math.min(i1+Math.abs(height[i]-height[i+1]), i2+Math.abs(height[i]-height[i+2]));
            i2 = i1;
            i1 = curr;
        }
        return i1;
    }
}