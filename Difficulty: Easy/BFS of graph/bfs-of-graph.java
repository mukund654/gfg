class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<adj.size();i++){
            if(vis[i]==false){
                q.add(i);
                findans(ans,adj,vis,q);
            }
        }
        return ans;
        
    }
    
    public void findans(ArrayList<Integer>ans, ArrayList<ArrayList<Integer>>adj, boolean vis[],Queue<Integer>q){
        int num = q.poll();
        ans.add(num);
        vis[num] = true;
        for(int i = 0;i<adj.get(num).size();i++){
            if(vis[adj.get(num).get(i)]==false){
                q.add(adj.get(num).get(i));
                vis[adj.get(num).get(i)]=true;
                
            }
        }if(!q.isEmpty()){
            findans(ans,adj,vis,q);
        }
    }
}