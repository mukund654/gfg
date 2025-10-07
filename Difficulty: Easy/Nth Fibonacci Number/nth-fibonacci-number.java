// User function Template for Java

class Solution {
    public int nthFibonacci(int n) {
        // code here
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int last = 1;
        int lastsec = 1;
        for(int i = 2;i<n;i++){
            int temp = lastsec;
            lastsec = last;
            last = last+temp;
        }
        return last;
    }
}