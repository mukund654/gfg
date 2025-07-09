class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int [] count = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<arr.length;i++){
            
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                count[i] = i+1;
            } 
            else{
                count[i] = i-st.peek();
               
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            st.pop();
        }
        
        for(int i = arr.length-1;i>=0;i--){
            
            while(!st.isEmpty() && arr[i]<arr[st.peek()]){
                st.pop();
                
            }
            
            if(st.isEmpty()){
                count[i] *= (arr.length-i);
                
            }
            else{
                count[i] *= st.peek()-i;
               
            }
            st.push(i);
        }
        
        int sum = 0;
        for(int i =0;i<arr.length;i++){
            sum += count[i]*arr[i];
        }
        return sum;
    }
}
