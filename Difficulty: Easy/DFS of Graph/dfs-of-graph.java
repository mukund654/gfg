class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
           ArrayList<Integer> ans = new ArrayList<>();
           boolean[]vis = new boolean[adj.size()];
           for(int i = 0;i<adj.size();i++){
               if(vis[i]==false){
                    findans(adj,ans,vis,i);
               }
              
           }
           return ans;
           
    }
    
    public void findans(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans, boolean[]vis,int ind){
        vis[ind] = true;
        ans.add(ind);
        for(int i = 0;i<adj.get(ind).size();i++){
            if(vis[adj.get(ind).get(i)]==false){
                findans(adj,ans,vis,adj.get(ind).get(i));
            }
        }
    }
}