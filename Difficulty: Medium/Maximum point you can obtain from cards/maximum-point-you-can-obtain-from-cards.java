class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // code here.
        int n = cardPoints.length;
        // will be creatinng leftpause and right pause, if right pointers value is greater than leftpause we will add it and decrease left pause
        int lp = n/2;
        int rp = lp+1;
        int left = 0;
        int right = n-1;
        int currsum = 0;
        
        for(int i = 0;i<n-k;i++){
            
                currsum += cardPoints[i];
            
        }
        int minsum = currsum;
        int totalsum = currsum;
        int j = 0;
        for(int i = n-k;i<n;i++){
            totalsum += cardPoints[i];
            currsum+= cardPoints[i];
            currsum -= cardPoints[j];
            j++;
            minsum = Math.min(currsum, minsum);
            
        }
        
        return totalsum- minsum;
        
    }
}
