
class RandomListNode {
    // Definition for a Node.
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public static Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }

        //clone each node so that it points to its clone
        //example
        //before: 1 -> 2 -> 3
        //after:  1 -> 1' -> 2 -> 2' -> 3 -> 3'
        Node cur = head;
        while (cur != null){
            Node dup = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = dup;
            cur = dup;
        }

        //make each clone point to its corresponding random node clone
        cur = head;
        while (cur != null){
            if (cur.random != null){
                //next random value points to the random values next 
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //restore the original list and extract the copy list
        cur = head;
        Node copyHead = head.next;
        Node copy = copyHead;

        while (copy.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            copy.next = copy.next.next;
            copy = copy.next;
        }
        cur.next = cur.next.next;

        return copyHead;
    }
}