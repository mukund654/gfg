class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        if(arr.length<=2){
            return 0;
        }
        int[][]mat = new int[arr.length][arr.length];
        return findans(mat,0,arr.length-1,arr);
    }
    static int findans(int[][]mat,int start,int end,int[]arr){
        if(mat[start][end]!=0){
            return mat[start][end];
        }
        if(end-start==2){
            mat[start][end] = arr[start]*arr[start+1]*arr[start+2];
            return mat[start][end];
        }
        int left = findans(mat,start,end-1,arr)+(arr[start]*arr[end]*arr[end-1]);
        int right = findans(mat,start+1,end,arr)+(arr[start]*arr[start+1]*arr[end]);
        mat[start][end] = Math.min(left,right);
        for(int i = start+2;i<=end-2;i++){
            int cent = findans(mat,start,i,arr)+findans(mat,i,end,arr)+(arr[start]*arr[i]*arr[end]);
            mat[start][end] = Math.min(cent,mat[start][end]);
        }
        return mat[start][end];
    }
}