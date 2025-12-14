class Solution {
    public void swapDiagonal(int[][] mat) {
        // code here
          int n = mat.length;
        for(int i = 0;i<mat.length;i++){
             int temp = mat[i][i];
             mat[i][i] = mat[i][n-1-i];
             mat[i][n-1-i] = temp;
        }
    }
}