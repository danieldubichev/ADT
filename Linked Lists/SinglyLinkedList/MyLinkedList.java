class MyLinkedList {
/*
    ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        [[],            [7],        [2],        [1],        [3,0],          [2],        [6],        [4],        [4],    [4],    [5,0],          [6]]

*/





public static void main (String[] args){
    MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
    System.out.println("Test");
    linkedList.addAtHead(7);
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
        //initializes a node with a value, points to nothing
        Node(int x) { 
            val = x; 
        }
        //initializes a node with a value, points to a newNextNode
        Node(int x, Node newNextNode) { 
            val = x;
            next = newNextNode; 
        }
        //initializes an empty node or "null node" pointing to nothing
        Node(){}
        //initializes an empty node pointing to a new node
        Node(Node newNextNode){
            next = newNextNode; 
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
        head = new Node(tail);
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (length <= index || index < 0){
            return -1;
        } else {
            //create a new node as the head to point, and iterate through the list until count matches index
            Node iterNode = head.next;
            int indexcount = 0;
            while (indexcount != index){
                iterNode = iterNode.next;
                indexcount++;
            }
            return iterNode.val;

        }
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head.next == tail){
            Node newHead = new Node(val, tail);
            head.next = newHead;
        } else {
            Node newHead = new Node(val, head.next);
            head.next = newHead;
        }
        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head.next == tail){
            
            Node newTail = new Node(val, tail);
            head.next = newTail;
        } else {
            //create a new node as the head to point, and iterate through the list until you are at the element just previous of the tail
            Node iterNode = head;
            while (iterNode.next != tail){
                iterNode = iterNode.next;
            }
            Node newTail = new Node(val, tail);
            iterNode.next = newTail;
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
        } else {

            Node iterNode = head;
            int indexcount = 0;
            while (indexcount != index){
                iterNode = iterNode.next;
                indexcount++;
            }
            Node newNode = new Node(val, iterNode.next);
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
        System.out.println("Length is: " + length);
        if (length <= index || index < 0){
            return;
        }
        else{
            Node iterNode = head;
            int indexcount = 0;
            while (indexcount!= index){
                iterNode = iterNode.next;
                indexcount++;
            }
            //case where we are deleting the tail
            if (iterNode.next == tail){
                iterNode.next = null;
            }else{
                Node newNode = iterNode.next;
                iterNode.next = iterNode.next.next;
                newNode = null;
            }
    }
    length--;
}
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */