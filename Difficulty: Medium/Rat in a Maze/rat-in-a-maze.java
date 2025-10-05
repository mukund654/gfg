class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
       ArrayList<String>ans = new ArrayList<>();
       // for(int i = 0;i<maze.length;i++){
            if(maze[0][0]==1){
                findans(0,0,ans,maze, new StringBuilder());   
            }
        //}
        return ans;
    }
    
    public void findans(int i, int j,  ArrayList<String>ans, int[][] maze, StringBuilder curr){
         maze[i][j]=0;
         if(i<maze.length-1 && maze[i+1][j]==1){
             curr.append("D");
             
             findans(i+1,j,ans,maze,curr);
             curr.deleteCharAt(curr.length()-1);
         }
         if(j>0 && maze[i][j-1]==1){
             curr.append("L");
             findans(i,j-1,ans,maze,curr);
             curr.deleteCharAt(curr.length()-1);
         }
         if(j<maze.length-1 && maze[i][j+1]==1){
             curr.append("R");
             findans(i,j+1,ans,maze,curr);
             curr.deleteCharAt(curr.length()-1);
         }
         if(i>0 && maze[i-1][j]==1){
             curr.append("U");
             findans(i-1,j,ans,maze,curr);
             curr.deleteCharAt(curr.length()-1);
         }
         
         if(i==maze.length-1 && j == maze.length-1){
             ans.add(curr.toString());
         }
         maze[i][j]=1;
    }
}