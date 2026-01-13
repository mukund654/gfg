class Solution {
    public boolean canServe(int[] arr) {
        // code here
        int f = 0;
        int t = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==5){
                f++;
            }
            else if(arr[i]==10){
                t++;
                f--;
                if(f<0){
                    return false;
                }
            }
            else{
                if(t>0){
                    t--;
                    f--;
                }
                else{
                    f-=3;
                }
                if(f<0){
                    return false;
                }
            }
        }
        return true;
    }
}