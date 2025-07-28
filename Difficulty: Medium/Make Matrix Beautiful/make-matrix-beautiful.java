class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
         int n = mat.length;
        int lastsum = 0;
        for(int i = 0;i<mat[0].length;i++){
            lastsum+= mat[n-1][i];
        }
        
        for(int j = 0;j<mat.length;j++){
            for(int i = 0;i<mat.length-1;i++){
                mat[mat.length-1][j] += mat[i][j];
            }
        }
        int first = mat[0][0];
        for(int i = 0;i<mat.length-1;i++){
            //if(i!=0){
                mat[0][i] = 0;
            //}
            
            for(int j=0;j<mat.length;j++ ){
                // if(i==0&& j==0){
                //     continue;
                // }
                mat[0][i] += mat[i][j];
                
            }
            if(i==0){
                mat[0][0] += first;            }
        }
        mat[0][n-1] = lastsum;
        
        int rmax = 0;
        int cmax = 0;
        
        for(int i = 0;i<n;i++){
            rmax = Math.max(rmax,mat[0][i]);
            cmax = Math.max(cmax, mat[n-1][i]);
        }
        
        int rsum = 0;
        int csum = 0;
        for(int i =0;i<n;i++){
            rsum += rmax-mat[0][i];
            //System.out.print(mat[0][i]);
            csum += cmax-mat[n-1][i];
             //System.out.print(mat[n-1][i]);
        }
        
        if(csum>rsum){
            return csum;
        }
        else{
            return rsum;
        }
    }
}