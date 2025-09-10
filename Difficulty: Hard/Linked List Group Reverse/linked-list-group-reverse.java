/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        if(k==1){
            return head;
        }
        Node slow = head;
        Node fast = head;
        int cnt = 1;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            cnt++;
        }
        int size = 0;
        if(fast.next==null){
            size = (cnt*2)-1;
        }
        else{
            size = cnt*2;
        }
        Node dummy = new Node(-1);
        dummy.next  = head;
        Node prev = dummy;
        Node curr = head;
        Node next = null;
        Node first = head;
        Node last = dummy;
        for(int i = 0;i<(size+1)/2;i++){
            int n = k;
           
            while(n>0 && curr!=null){
                n--;
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr= next;
                
            }
            
            first.next = curr;
            last.next = prev;
            last = first;
            first = curr;
            
            if(curr==null){
                break;
            }
        }
        return dummy.next;
        
    }
}