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
            Node temp = pointer.child;
            while(temp.next != null){
                temp = temp.next;
            }
            //connect the tail with pointer next value if it is not null
            System.out.println(pointer.next.val);
            //in the test case the end of our tail (10) point to 4 now
            temp.next = pointer.next;
            
            if (pointer.next != null){
                pointer.next.prev = temp;
                //4 now points back to 10
                System.out.println(pointer.next.prev.val);
            }
            pointer.next = pointer.child;
            //the pointer (3) is now pointing to the beginning of the child
            System.out.println(pointer.next.val);
            pointer.child.prev = pointer;
            //7 now points to 3 (prev)
            System.out.println(pointer.next.val);
            System.out.println(pointer.val);
            //the child can be null now as it is transferred to the main flattenned list!
            pointer.child = null;
            //now repeat the same process for all future child values!
        }

        return head;
    }
}


