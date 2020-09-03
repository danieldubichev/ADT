public class LinkedListCycle {

 // Definition for singly-linked list.
  static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public static void main(String[] args){
        //Example 1
        //head = [3,2,0,-4], pos = 1
        ListNode heade1 = new ListNode(3);
        ListNode twoe1 = new ListNode(3);
        ListNode threee1 = new ListNode(3);
        ListNode foure1 = new ListNode(3);

        heade1.next = twoe1;
        twoe1.next = threee1;  
        twoe1.next = threee1;
        threee1.next = foure1;
        foure1.next = twoe1;

        //Example 2
        ListNode heade2 = new ListNode(3);
        ListNode twoe2 = new ListNode(3);

        heade2.next = twoe2;
        twoe2.next = heade2;

        //Example 3
        //ListNode heade3 = new ListNode(1);
    }

    public static boolean hasCycle(ListNode head) {

        if ( head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static ListNode detectCycle(ListNode head) {

        if ( head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}