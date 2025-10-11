/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Node> q = new LinkedList<>();
        q.addFirst(null);
        q.addFirst(root);
        findans(root,ans,q);
        return ans;
    }
    
    public void findans(Node root, ArrayList<Integer> ans, Deque<Node>q){
        int n = 0;
        while(!q.isEmpty()){
            if(n==0){
                if(q.peekFirst()!=null){
                    Node curr = q.peekFirst();
                    if(curr.left!=null){
                        q.addLast(curr.left);
                    }
                    if(curr.right!=null){
                        q.addLast(curr.right);
                    }
                    ans.add(q.pollFirst().data);
                }
                else{
                    if(q.size()==1){
                        break;
                    }
                    n++;
                }
            }
            else{
                if(q.peekLast()!=null){
                    Node curr = q.getLast();
                    if(curr.right!=null){
                        q.addFirst(curr.right);
                    }
                    if(curr.left!=null){
                        q.addFirst(curr.left);
                    }
                    ans.add(q.pollLast().data);
                }
                else{
                    if(q.size()==1){
                        break;
                    }
                    n--;
                }
            }
        }
    }
}