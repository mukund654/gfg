class Solution {
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        ArrayList<Integer>list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);  
        }
        for(int i = 0;i<arr.length;i++){
            findans(list,set,ans,new ArrayList<>(),"",i);
        }
        return ans;
    }
    
    public static void findans(ArrayList<Integer>list,HashSet<String> set, ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> curr,String s,int n){
        s = s+list.get(n)+"#";
        curr.add(list.get(n));
        int num = list.get(n);
        list.remove(n);
        if(list.size()==0 && !(set.contains(s))){
            set.add(s);
            ans.add(new ArrayList<>(curr));
            list.add(n,num);
            curr.remove(curr.size()-1);
            return;
        }
        for(int i = 0;i<list.size();i++){
            findans(list,set,ans,curr,s,i);
        }
        curr.remove(curr.size()-1);
        list.add(n,num);
    }
};