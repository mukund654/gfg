

// User function Template for Java
class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        if(left.length>0 && right.length==0){
             int max = left[0];
             for(int i =0;i<left.length;i++){
                max = Math.max(max,left[i]);
             }
             return max;
        }
        if(right.length>0 && left.length==0){
            int min = right[0];
            for(int i =0;i<right.length;i++){
                min = Math.min(min,right[i]);
            }
            return n-min;
        }
        if(left.length>0 && right.length>0){
            int max = left[0];
            for(int i =0;i<left.length;i++){
                max = Math.max(max,left[i]);
            }
            int min = right[0];
            for(int i =0;i<right.length;i++){
                min = Math.min(min,right[i]);
            }
            return Math.max(max,n-min);
        }
        // else if(left.length>0){
        //     return max;
        // }
        // else{
        //     return n-min;
        // }
        return 0;
        
    }
}