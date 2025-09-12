/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    int maxPathSum(Node root) {
        // code here
       // int[] sum = 0;
        int[] max = {Integer.MIN_VALUE};
        
        int ans = findans(max,root);
        if(root.left==null || root.right==null){
            return Math.max(max[0],ans);
        }
        return max[0];
    }
    int findans( int[]max, Node root){
      
        if(root.left==null && root.right==null){
            
            return root.data;
        } 
        int left = (root.left!=null)? findans(max,root.left): Integer.MIN_VALUE;
        int right = (root.right!=null)? findans(max,root.right): Integer.MIN_VALUE;
        
        if(root.left!=null && root.right!=null){
            max[0] = Math.max(max[0], root.data+left+right);
            return Math.max(root.data+left, root.data+right);
        }
        if(root.left!=null){
            return root.data+left;
        }
        else{
            return root.data+right;
        }
    }
}