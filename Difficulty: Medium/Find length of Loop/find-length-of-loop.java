/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head;
        Node fast= head;
        if(head.next==null){
            return 0;
        }
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast!=slow){
            return 0;
        }
        
        slow = head;
        int cnt = 1;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        slow = slow.next;
        while(fast!=slow){
            slow= slow.next;
            cnt++;
        }
        return cnt;
        
    }
}