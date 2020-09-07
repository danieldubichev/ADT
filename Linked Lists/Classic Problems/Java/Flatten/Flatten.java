public class Flatten {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if (head == null) {return null;}
        Node pointer = head;
        //iterate
        while (pointer != null){
            //if no child; continue
            if(pointer.child == null){
                pointer = pointer.next;
                continue;
            }

            //if child found
            //find child tail
            Node temp = p.child;
            while(temp.next != null){
                temp = temp.next;
            }
            //connect the tail with pointer next value if it is not null
            temp.next = pointer.next;
            if (pointer.next != null){
                pointer.next.prev = temp;
            }
            pointer.next = pointer.child;
            pointer.child.prev = pointer;
            pointer.child = null;
        }

        return head;
    }
}
