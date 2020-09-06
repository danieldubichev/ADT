class MyLinkedList {


    public static void main (String[] args){
        MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
        System.out.println("Test");
        linkedList.addAtHead(7);
        System.out.println("Test");
        printList();
        linkedList.addAtHead(2);
        printList();
        linkedList.addAtHead(1);
        printList();
        linkedList.addAtIndex(3,0);
        printList();
        linkedList.deleteAtIndex(2);
        printList();
        linkedList.addAtHead(6);
        printList();
        linkedList.addAtTail(4);
        printList();
        System.out.println("At position 4 we have: " + linkedList.get(4)); 
        printList();
        linkedList.addAtHead(4);
        printList();
        linkedList.addAtIndex(5,0);
        printList();
        linkedList.addAtHead(6);
        printList();
    }
    class Node {
        int val;
        Node next;
        Node prev;
        //initializes a node with a value, points to nothing
        Node(int x) { 
            val = x; 
        }
        //initializes a node with a value, points to a newNextNode, also 
        Node(int x, Node newNextNode, Node newPrevNode) { 
            val = x;
            next = newNextNode; 
            prev = newPrevNode;
        }
        //initializes an empty node or "null node" pointing to nothing
        Node(){}
        //initializes an empty node pointing to a new node
        Node(Node newNextNode, Node newPrevNode){
            next = newNextNode; 
            prev = newPrevNode;
        }
    }

    //length variable is helpful for index error checking, if index is greater than length return -1
    static int length;
    //head node variable is helpful to point to the head of our list, and to easily reference it (addAtHead function)
    static Node head;
    //tail node variable is helpful to point to the tail of our list, and to easily reference it (addAtTail function)
    static Node tail;


    /** Initialize your data structure here. */
    public MyLinkedList() {
        //initialize head and tail pointers
        //our list will look something like:
        // head <=> 3 <=> 4 <=> 9 <=> tail
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;        
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        //this means that the index is out of bounds.
        //then return "-1"
        if (length <= index || index < 0){
            return -1;
        //else index is not out of bounds

        } else {
            //create a new node as the head to point, and iterate through the list until count matches index
            Node iterNode = head.next;
            int indexcount = 0;
            //iterate until the index is reached
            while (indexcount != index){
                iterNode = iterNode.next;
                indexcount++;
            }
            return iterNode.val;

        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        //if the list is empty (heads next value is tail)
        if (head.next == tail){
            System.out.println("lol");
            //if create the new head and and point it to head and tail
            Node newHead = new Node(val, tail, head);
            //head next value becomes newhead
            head.next = newHead;
            //tail prev value become new head
            tail.prev = newHead;
        } else {
            Node newHead = new Node(val, head.next, head);
            head.next.prev = newHead;
            head.next = newHead;
        }
        length++;
        
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
        if (head.next == tail){
            
            Node newTail = new Node(val, tail, head);
            head.next = newTail;
            tail.prev = newTail;
        } 
        
        
        else {
            Node newTail = new Node(val, tail, tail.prev);
            tail.prev.next = newTail;
            tail.prev = newTail;
        }
        length++;
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        if (length < index || index < 0){

            return;
        } else if (index == length){

            addAtTail(val);
        } else if (index == 0){

            addAtHead(val);
        
        }else {
            Node iterNode = head;
            int indexcount = 0;
            while (indexcount != index){
                iterNode = iterNode.next;
                indexcount++;
            }
            Node newNode = new Node(val, iterNode.next, iterNode.prev);
            iterNode.next.prev = newNode;
            iterNode.next = newNode;
            length++;
    }
}
        
    
// For Testing
    public static void printList(){

        System.out.println("Printing List");
        Node iterNode = head.next;

        for (int i = 0; i < length; i++){
            System.out.println(iterNode.val);
            iterNode = iterNode.next;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if (length <= index || index < 0){
            return;
        } else {
            Node iterNode = head;
            int indexcount = 0;
            while (indexcount!= index){
                iterNode = iterNode.next;
                indexcount++;
            }
            if (iterNode.next == tail){
                iterNode.next = null;
            } else {
                Node newNode = iterNode.next;
                iterNode.next = iterNode.next.next;
                iterNode.next.prev = iterNode;
                newNode = null;
            }
        }
        length--;
}
}