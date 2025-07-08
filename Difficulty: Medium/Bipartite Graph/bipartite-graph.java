class Solution {
   
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<Integer>[] arr = new ArrayList[V];
        for(int i = 0;i<V;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0;i<edges.length;i++){
            arr[edges[i][0]].add(edges[i][1]);
            arr[edges[i][1]].add(edges[i][0]);
        }
        HashMap<Integer,String> map = new HashMap<>();
        boolean [] visited = new boolean[V];
        for(int i = 0;i<V;i++){
            if(visited[i]==false){
                giveind( arr,visited,"odd",i,map);
            }
        }
        
        
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].size();j++){
                if(map.get(i).equals(map.get(arr[i].get(j)))){
                    return false;
                }
            }
        }
        return true;
        
    }
    public void giveind( ArrayList<Integer>[] arr, boolean [] visited ,String index,int source,HashMap<Integer,String> map){
        visited[source] = true;
        map.put(source,index);
        if(index.equals("odd")){
            index = "even";
        }
        else{
            index = "odd";
        }
        
        for(int i = 0;i<arr[source].size();i++){
            int num = arr[source].get(i);
            if(!visited[num]){
                giveind(arr,visited,index,num,map);
            }
        }
        
        
    }
}