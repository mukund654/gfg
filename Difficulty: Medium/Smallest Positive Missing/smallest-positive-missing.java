class Solution {
    public int missingNumber(int[] arr) {
        // code here
        for(int i = 0;i<arr.length;i++){
            int temp = arr[i];
            while(temp>0 && temp<=arr.length&& temp!=arr[temp-1]){
                int newtemp = temp;
                temp = arr[temp-1];
                arr[newtemp-1] = newtemp;
            }
        }
        
        for(int i = 0;i<arr.length;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        
        return arr.length+1;
    }
}
