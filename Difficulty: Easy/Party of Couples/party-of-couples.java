// User function Template for Java

class Solution {
    static int findSingle(int[] arr) {
        // code here
        int num = 0;
        for(int i= 0;i<arr.length;i++){
            num ^= arr[i];
        }   
        return num;
    }
}