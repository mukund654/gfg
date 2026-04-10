// User function Template for Java

class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        // code here
        Node root = new Node();
        String[] ans = new String[arr.length];
        for(int i = 0;i<arr.length;i++){
            insert(root,arr[i]);
            
        }
        for(int i = 0;i<arr.length;i++){
            makeunique(root,arr[i],ans,i);
        }
        
        return ans;
    }
    
    static class Node{
        Node[] a = new Node[26];
        boolean eow = false;
        
        public Node(){
            for(int i = 0;i<26;i++){
                a[i] = null;
            }
        }
    }
    
    static void insert(Node root, String word){
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int ind = word.charAt(i)-'a';
            if(curr.a[ind]==null){
                curr.a[ind] = new Node();
            }
            curr = curr.a[ind];
        }
        curr.eow = true;
        
    }
    
    static void makeunique(Node root,String word,String[]ans, int index){
        Stack <Node> st = new Stack<>();
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int ind = word.charAt(i)-'a';
            st.push(curr.a[ind]);
            curr = curr.a[ind];
        }
        for(int i = 0;i<word.length();i++){
            curr = st.pop();
            int cnt = 0;
            for(int j = 0;j<26;j++){
                if(curr.a[j]!=null){
                    cnt++;
                }
            }
            if(cnt>1){
                ans[index] = word.substring(0,st.size()+2);
                return;
            }
        }
        ans[index] = word.substring(0,1);
        
    }
};