class Solution {
    public static int countSubs(String s) {
        // code here
        Node root = new Node();
       int []count = new int[1];
        String[] a= new String[s.length()];
        for(int i = 0;i<a.length;i++){
            a[i] = s.substring(i);
            insert(root, a[i]);
        }
        for(int i = 0;i<a.length;i++){
            search(root, a[i], count);
        }
        return count[0];
        
        
    }
    public static class Node{
        Node [] arr = new Node[26];
        boolean vis = false;
        public Node(){
            for(int i = 0;i<26;i++){
                arr[i] = null;
            }
        }
    }
    public static void insert(Node root, String word){
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int ind = word.charAt(i)-'a';
            if(curr.arr[ind]==null){
                curr.arr[ind] = new Node();
            }
            curr = curr.arr[ind];
        }
    }
    
    public static void search(Node root, String word, int[]count){
        Node curr = root;
        for(int i = 0;i<word.length();i++){
            int ind = word.charAt(i)-'a';
            
            curr = curr.arr[ind];
            if(curr.vis==false){
                count[0]++;
                curr.vis = true;
            }
        }
    }
    
    
}