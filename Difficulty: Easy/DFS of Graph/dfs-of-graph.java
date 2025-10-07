class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        // HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        // for(int i = 0;i<adj.size();i++){
        //     map.put(i,new ArrayList<>());
        //     for(int j = 0;j<adj.get(i).size();i++){
        //         map.get(i).add(adj.get(i).get(j));
        //     }
        // }
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[]visited = new boolean[adj.size()];
        for(int i = 0;i<adj.size();i++){
            if(!visited[i]){
                dfstrav(visited,adj,i,ans);
            }
        }
        
        return ans;
        
    }
    
    public void dfstrav( boolean[]visited,ArrayList< ArrayList<Integer>> adj ,int ind,ArrayList<Integer> ans ){
        visited[ind] = true;
        ans.add(ind);
        for(int i = 0;i<adj.get(ind).size();i++){
            if(!visited[adj.get(ind).get(i)]){
                dfstrav(visited,adj,adj.get(ind).get(i),ans);
            }
        }
    }
}