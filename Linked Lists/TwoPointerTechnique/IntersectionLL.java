
public class IntersectionLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode aPointer = headA, bPointer = headB;
        while (aPointer != bPointer){
            if (aPointer != null){
                aPointer = aPointer.next;
            } else { 
                aPointer = headB;
            }
            if (bPointer != null){
                bPointer = bPointer.next;
            } else { 
                bPointer = headA;
            }
    }
        return aPointer;
}
}