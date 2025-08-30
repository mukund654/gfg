class Solution {
    public int celebrity(int mat[][]) {
        // code here
        if(mat.length==1){
            return 0;
        }
        int col = -1;
        for(int j = 0;j<mat.length;j++){
            int count = 0;
            for(int i = 0;i<mat.length;i++){
                if(i==j){
                    continue;
                }
                if(mat[i][j]==1){
                    count++;
                }
                if(count==mat.length-1){
                    col = j;
                    
                }
            }
            if(col!=-1){
                break;
            }
        }
        
        if(col==-1){
            return -1;
        }
        int count = 0;
        for(int i = 0;i<mat.length;i++){
            if(col==i){
                continue;
            }
            if(mat[col][i]==1){
                count++;
            }
        }
        if(count==0){
            return col;
        }
        else{
            return -1;
        }
    }
}