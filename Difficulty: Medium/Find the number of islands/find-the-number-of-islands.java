class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        //int [] count = new int[1];
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]=='L'){
                    findans(grid,i,j);
                    ans++;
                }
                
            }
        }
        return ans;
        
        
    }
    
    public void findans(char[][]grid, int r, int c){
        grid[r][c]='W';
        if(r<grid.length-1 && grid[r+1][c]=='L'){
            findans(grid,r+1,c);
        }
        if(c<grid[0].length-1 && grid [r][c+1]=='L'){
            findans(grid,r,c+1);
        }
        if(c<grid[0].length-1 && r<grid.length-1 && grid [r+1][c+1]=='L'){
            findans(grid,r+1,c+1);
        }
        if(r>0 && grid[r-1][c]=='L'){
            findans(grid,r-1,c);
        }
        if(c>0 && grid[r][c-1]=='L'){
            findans(grid,r,c-1);
        }
        if(r>0 && c>0 && grid[r-1][c-1]=='L'){
            findans(grid,r-1,c-1);
        }
        if(r>0 && c<grid[0].length-1 && grid[r-1][c+1]=='L'){
            findans(grid,r-1,c+1);
        }
        if(r<grid.length-1 && c>0 && grid[r+1][c-1]=='L'){
            findans(grid,r+1,c-1);
        }
    }
}