class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        if(k>9){
            return ans;
        }
        int min = (k*(k+1))/2;
        int num = 9;
        int max = 0;
        for(int i = 0;i<k;i++){
            max+= num;
            num--;
        }
        if(n<min || n>max){
            return ans;
        }
        for(int i =1;i<9-k+2;i++){
            findans(ans, curr, 0,i,n,k);
        }
        
        return ans;
        
    }
    void findans(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> curr,int sum,int num,int n,int k){
        sum+= num;
        curr.add(num);
        if(sum==n && k==1){
            ans.add(new ArrayList<>(curr));
        }
        if(k==1 || sum>=n){
            curr.remove(curr.size()-1);
            return;
        }
        for(int i = num+1;i<=9;i++){
            findans(ans,curr,sum,i,n,k-1);
        }
        curr.remove(curr.size()-1);
    }
}