class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        Arrays.sort(prices);
        int start = 0;
        int end = prices.length-1;
        int min = 0;
        int max = 0;
        while(start<=end){
            min+= prices[start];
            end -=k;
            start++;
        }
        for(int i = prices.length-1;i>=prices.length-start;i--){
            max+= prices[i];
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(min);
        ans.add(max);
        return ans;
    }
}
