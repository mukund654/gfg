class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer>ans = new ArrayList<>();
        
        for(int i= arr.length-1;i>=0;i--){
            while(!st.isEmpty()){
                if(map.get(st.peek())<=map.get(arr[i])){
                    st.pop();
                }
                else{
                    ans.add(st.peek());
                    st.push(arr[i]);
                    break;
                }
            }
            if(st.isEmpty()){
                ans.add(-1);
                st.push(arr[i]);
            }
            
        }
        
        Collections.reverse(ans);
        return ans;
    }
}