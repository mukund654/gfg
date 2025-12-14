class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        // code here
         ArrayList<Integer> ans = new ArrayList<>();
        int msum = 0;
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                mat[i][j] += msum;
                msum = mat[i][j];
            }
        }
        for(int i = 0;i<queries.length;i++){
            int up = queries[i][0];
            int left = queries[i][1];
            int down = queries[i][2];
            int right = queries[i][3];
            int sum =0;
            for(int j = up;j<=down;j++){
                if(left!=0){
                    sum+= mat[j][right]-mat[j][left-1];
                }
                else{
                    if(j==0){
                        sum+= mat[j][right];
                    }
                    else{
                        sum+= mat[j][right]-mat[j-1][mat[j].length-1];
                    }
                }
            }
           
            ans.add(sum);
        }
        return ans;
    }
}
