class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum += arr[i]*(arr.length-i)*(i+1);
        }
        // sum += arr[0]*arr.length;
        // sum+= arr[arr.length-1]*arr.length;
        return sum;
    }
}
