class Solution {
    public ArrayList<String> possibleWords(int[] arr) {
        // code here
        ArrayList<String> ans = new ArrayList<>();
        HashMap<Integer,ArrayList<String>> map = new HashMap<>();
        map.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
        map.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
        map.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
        map.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
        map.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
        map.put(7, new ArrayList<>(Arrays.asList("p", "q", "r" , "s")));
        map.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
        map.put(9, new ArrayList<>(Arrays.asList("w", "x", "y" , "z")));
        ArrayList<Integer> nums = new ArrayList<>();
        
        //for(int i = 0;i<arr.lenght;i++){
            findans(ans,"",0,map,arr);
        //}
        return ans;
    }
    
    public void findans(ArrayList<String> ans,String curr,int n,HashMap<Integer,ArrayList<String>> map, int []arr){
        if(n==arr.length){
            ans.add(curr);
            return;
        }
        if(arr[n]>9|| arr[n]<2){
            findans(ans,curr,n+1,map,arr);
            return;
        }
        for(int i = 0;i<map.get(arr[n]).size();i++){
            curr = curr+map.get(arr[n]).get(i);
            
            findans(ans,curr,n+1,map,arr);
            curr =  curr.substring(0,curr.length()-1);
        }
    }
}