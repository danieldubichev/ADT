
import java.lang.Math;

class mergeTwoLists {
    public static class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args){


    }
    public static void printList(ListNode head){

        System.out.println("Printing List");
        ListNode iterNode = head;

        while (iterNode != null){
            System.out.println(iterNode.val);
            iterNode = iterNode.next;
        }
    }
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        //base cases
        if (l1 == null && l2 == null){
            return null;
        }

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode result = new ListNode(0);
        ListNode prev = result;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null){
            prev.next = l1;
        }
        if (l2 != null){
            prev.next = l2;
        }
        return result.next;

    }
}