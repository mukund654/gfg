class Solution {
    public int totalWays(int[] arr, int target) {
        // code here
        //HashSet<Integer> set = new HashSet<>();
        int total = 0;
        for(int i = 0;i<arr.length;i++){
            total+= arr[i];
        }
        if(total==target)return 1;
        
        if((total+target)%2!=0){
            return 0;
        }
        int [] freq = new int[total+1];
        for(int i =0;i<arr.length;i++){
            
            for(int j = total;j>0;j--){
                if(freq[j]>0){
                    freq[j+arr[i]]+= freq[j];
                }
                
            }
            freq[arr[i]]++;
        }
        
        return freq[(total-target)/2];
        
        
    }
}