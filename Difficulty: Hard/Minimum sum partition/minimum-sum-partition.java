// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        if(arr.length==1){
            return arr[0];
        }
        if(arr.length==2){
            return Math.abs(arr[1]-arr[0]);
        }
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum+= arr[i];
        }
        int[][]mat = new int[arr.length][sum];
        mat[0][arr[0]-1]=1;
        for(int i = 0;i<arr.length-1;i++){
            for(int j = 0;j<sum;j++){
                if(mat[i][j]==1){
                    mat[i+1][arr[i+1]+j]=1;
                    mat[i+1][j-arr[i]+arr[i+1]]=1;
                }
            }
        }
        for(int j = sum/2-1;j>=1;j--){
            for(int i = 0;i<arr.length;i++){
                if(mat[i][j]==1){
                    return sum-j-j-2;
                }
            }
        }
        return 0;
    }
}
