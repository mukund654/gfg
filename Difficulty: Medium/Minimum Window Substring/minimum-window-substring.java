class Solution {
    public String minWindow(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int [][] mat = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(s1.charAt(j)==s2.charAt(i)){
                    mat[i][j] = 1;
                }
            }
        }    
            if(m>n){
                return "";
            }
            int currend = -1;
            int currstart = -1;
            int start = -1;
            int end = -1;
            for(int k =0;k<n;k++){
                int r = 0;
                int j = k;
                
                if(mat[r][j]==1){
                    r++;
                     if(m==1){
                         return s2;
                     }
                        for(int l = j+1;l<n;l++){
                            if(mat[r][l]==1){
                                r++;
                                if(r==m){
                                   currend = l;
                                   currstart = k;
                                   break;
                                }
                            }
                        }
                   
                   
                   if(currend!=-1){
                       if(start==-1){
                           start = currstart;
                           end = currend;
                       }
                       else if(end-start>currend-currstart){
                           start = currstart;
                           end = currend;
                       }
                   }
                   
                    
                   
                }
                
                
                
                
            }
            
        
        if(start==-1){
            return "";
        }
        return s1.substring(start,end+1);

        
    }
}
