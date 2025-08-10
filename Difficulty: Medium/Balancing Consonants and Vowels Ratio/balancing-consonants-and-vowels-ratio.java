class Solution {
    public int countBalanced(String[] arr) {
        // code here
        int count = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length();j++){
                if(arr[i].charAt(j)=='a' || arr[i].charAt(j)=='e' || arr[i].charAt(j)=='i' || arr[i].charAt(j)=='o' || arr[i].charAt(j)=='u' ){
                    count++;
                }
                else{
                    count--;
                }
            }
            if(map.containsKey(count)){
                ans+= map.get(count);
                
            }
            map.put(count, map.getOrDefault(count, 0)+1);
        }
        return ans;
        
    }
}