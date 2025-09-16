/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    static Node dummy = new Node(-1);
    static Node subLinkedList(Node head1, Node head2) {
        // code here
         head1 = trim(head1);
        head2 = trim(head2);

        int l1 = findlength(head1);
        int l2 = findlength(head2);

        Node temp1, temp2;

        if (l1 > l2) {
            temp1 = head1;
            temp2 = head2;
        } else if (l1 < l2) {
            temp1 = head2;
            temp2 = head1;
        } else {
            Node[] arr = new Node[2];
            Node result = tiebreaker(head1, head2, arr);
            if (result != null) return result; 
            temp1 = arr[0];
            temp2 = arr[1];
        }

        temp1 = reverse(temp1);
        temp2 = reverse(temp2);

        Node dummy = new Node(-1);  
        Node temp = dummy;

        while (temp2 != null) {
            if (temp1.data < temp2.data) {
                temp1.data += 10;
                Node trav = temp1.next;
                while (trav != null && trav.data == 0) {
                    trav.data = 9;
                    trav = trav.next;
                }
                if (trav != null) trav.data--;
            }
            temp.next = new Node(temp1.data - temp2.data);
            temp = temp.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null) {
            temp.next = new Node(temp1.data);
            temp = temp.next;
            temp1 = temp1.next;
        }

        Node head = reverse(dummy.next);
        return trim(head);
    }

    static Node tiebreaker(Node head1, Node head2, Node[] arr) {
        Node temp1 = head1;
        Node temp2 = head2;
        while (temp1 != null && temp1.data == temp2.data) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        if (temp1 == null) {
            return new Node(0);  
        }
        if (temp1.data < temp2.data) {
            arr[0] = head2;
            arr[1] = head1;
        } else {
            arr[0] = head1;
            arr[1] = head2;
        }
        return null;
    }

    static Node reverse(Node head) {
        Node prev = null, next = null, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static Node trim(Node head) {
        while (head != null && head.next != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    static int findlength(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
