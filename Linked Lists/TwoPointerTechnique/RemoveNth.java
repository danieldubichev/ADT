class RemoveNth{
    

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }



    }
    public static void main(String[] args){
        
        ListNode heade1 = new ListNode(1);
        ListNode twoe1 = new ListNode(2);



        heade1.next = twoe1;
        ListNode lol = removeNthFromEnd(heade1, 1);
        System.out.println(lol.val);

    }








    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (head == null){
            return null;
        }
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 1; i <= n+1; i++){
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    
    }


}