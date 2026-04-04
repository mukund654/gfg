class Solution {
    public ArrayList<String> graycode(int n) {
        // code here
        ArrayList<StringBuilder> ans = new ArrayList<>();
        
        ans.add(new StringBuilder("0"));
        ans.add(new StringBuilder("1"));
      
        for(int i = 2;i<=n;i++){
            int m = ans.size();
            for(int j = m-1;j>=0;j--){
                ans.add(new StringBuilder(ans.get(j)));
            }
            for(int j = 0;j<m;j++){
                ans.get(j).insert(0,"0");
            }
            for(int j = m;j<ans.size();j++){
                ans.get(j).insert(0,"1");
            }
        }
        ArrayList<String> a = new ArrayList<>();
        for(int i = 0;i<ans.size();i++){
            a.add(ans.get(i).toString());
        }
        return a;
    }    
}