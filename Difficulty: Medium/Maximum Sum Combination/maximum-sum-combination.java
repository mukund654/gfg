class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        // reverse(a);
        // reverse(b);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[0]-x[0]);
        HashSet<String> map = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        pq.add(new int[]{a[a.length-1]+b[a.length-1], a.length-1,a.length-1});
        map.add("0#0");
        
        while(ans.size()<k && !pq.isEmpty()){
            int[]top = pq.poll();
            ans.add(top[0]);
            
            int i = top[1];
            int j = top[2];
            
            if(i>0 && !map.contains((i-1)+"#"+j)){
                pq.offer(new int[]{a[i-1]+b[j],i-1,j});
                map.add((i-1)+"#"+j);
            }
            
            if(j>0 && !map.contains(i+"#"+(j-1))){
                pq.add(new int[]{a[i]+b[j-1],i,j-1});
                map.add(i+"#"+(j-1));
            }
        } 
        return ans;
    }
}