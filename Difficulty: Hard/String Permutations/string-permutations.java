// User function Template for Java

class Solution {
    public ArrayList<String> permutation(String S) {
        // Your code here
        int [] arr = new int[26];
        for(int i = 0;i<S.length();i++){
            arr[S.charAt(i)-'A']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<26;i++){
            while(arr[i]>0){
                sb.append((char)(i+'A'));
                arr[i]--;
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0;i<sb.length();i++){
            StringBuilder st = new StringBuilder();
            findans(sb,i,ans,st);
        }
        Collections.sort(ans);
        return ans;
        
    }
    
    public void findans(StringBuilder sb, int ind, ArrayList<String> ans, StringBuilder st){
        st.append(sb.charAt(ind));
        sb.deleteCharAt(ind);
        if(sb.length()==0){
            sb.append(st.charAt(st.length()-1));
            ans.add(st.toString());
            st.deleteCharAt(st.length()-1);
            return;
        }
        for(int i = 0;i<sb.length();i++){
            findans(sb,i,ans,st);
        }
        sb.insert(ind, st.charAt(st.length()-1));
        st.deleteCharAt(st.length()-1);
        
    }
}
