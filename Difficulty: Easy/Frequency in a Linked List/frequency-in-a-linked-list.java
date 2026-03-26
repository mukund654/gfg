/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
// complete the below function
class Solution {
    public static int count(Node head, int key) {
        // code here
        int ans = 0;
        while(head!=null){
            if(head.data==key){
                ans++;
            }
            head = head.next;
        }
        return ans;
    }
}