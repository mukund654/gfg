class Solution {
    public String longestValidWord(String[] words) {
        // code here
        Node root = new Node();
        for(int i = 0;i<words.length;i++){
            insert(root,words[i]);
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            if(ans.size()>0 && ans.get(0).length()>words[i].length()){
                    continue;
                
            }
            if(search(root,words[i])){
                if(ans.size()>0 &&words[i].length()>ans.get(0).length()){
                    ans.clear();
                    
                }
                ans.add(words[i]);
            }
        }
        Collections.sort(ans);
        if(ans.size()==0)return "";
        return ans.get(0);
        
    }
    public class Node{
        Node [] a= new Node[26];
        boolean eow = false;
        public Node(){
            for(int i = 0;i<26;i++){
                a[i]  = null;
            }
        }
    }
    public void insert(Node root, String word){
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
    
    public boolean search(Node root, String word){
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int ind = word.charAt(i)-'a';
            curr = curr.a[ind];
            if(curr.eow==false){
                return false;
            }
        }
        return true;
    }
}