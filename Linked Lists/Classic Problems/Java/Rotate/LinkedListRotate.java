public class LinkedListRotate {

 // Definition for singly-linked list.
 public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 public static void main(String[] args){
    ListNode test = new ListNode(1, new ListNode(2, new ListNode(3)));
    print(rotateRight(test,1));

 }
    
 public static void print(ListNode Cur){
    System.out.println("Printing");
    while (Cur != null){
        System.out.println(Cur.val);
        Cur = Cur.next;
    }
}
 public static ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (k == 0){
            return head;
        }
        //create dummy node that points to head
        ListNode dummynode = new ListNode(0, head);
        ListNode ref = dummynode;
        int count = 0;
        //iterate to the end of the list
        while (dummynode.next != null){
            count++;
            dummynode = dummynode.next;
        }
        //count - (k modulo count) is where head needs to be
        int headpos = count - (k % count);
        if (headpos == 0){
            return head;
        }
        dummynode = ref;
        
        //we now know what position head should be in so we iterate to that position
        //once at that position, create a new node that points to the node after head, 
        //and delete heads reference to that node
        //iterate to the end of the new node and attach it to head;
    
        while (headpos != 0){
            headpos--;
            dummynode = dummynode.next;
        }
    
        ListNode dummyheadref = ref.next;
        //System.out.println(dummyheadref.next.val);
        ref = dummynode;
    
        ListNode newHead = new ListNode();
        ListNode newHeadref = newHead;
        while (dummynode.next != null){
            newHead.next = dummynode.next;
            newHead = newHead.next;
            dummynode = dummynode.next;
            System.out.println(newHead.val);
        }
    
        ref.next = null;
      
        newHead.next = dummyheadref;
    
        return newHeadref.next;
        }

}
