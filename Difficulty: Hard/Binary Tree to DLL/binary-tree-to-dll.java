/*
class Node {
    int data;
    Node left, right;

    Node() {
        this.data = 0;
        this.left = this.right = null;
    }

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
*/
class Solution {
    static Node dummy;
    static Node temp;
    Node bToDLL(Node root) {
        // code here
        dummy = new Node(-1);
        temp = null;
        findans(root);
        Node head = dummy.right;
        head.left = null;
        dummy.right = null;
        return head;
    }
    
    void findans(Node root){
        if(root.left!=null){
            findans(root.left);
        }
        if(temp==null){
            dummy.right = root;
            root.left = dummy;
        }
        else{
            temp.right = root;
            root.left = temp;
        }
        temp = root;
        if(root.right!=null){
            findans(root.right);
        }
    }
}