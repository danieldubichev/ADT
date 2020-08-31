Each node in a singly-linked list contains not only the value but also a reference field to link to the next node. 

By this way, the singly-linked list organizes all the nodes in a sequence.


// Definition for singly-linked list in Java
public class SinglyListNode {
    int val;
    SinglyListNode next;
    SinglyListNode(int x) { val = x; }
}

In most cases, we will use the head node (the first node) to represent the whole list.


Operations
Unlike the array, we are not able to access a random element in a singly-linked list in constant time. 
If we want to get the ith element, we have to traverse from the head node one by one. 

It takes us O(N) time on average to visit an element by index, where N is the length of the linked list.


23 -> 6 -> 15


For instance, in the example above, the head is the node 23. The only way to visit the 3rd node is to use the "next" field of the head node to get to the 2nd node (node 6); Then with the "next" field of node 6, we are able to visit the 3rd node.

You might wonder why the linked list is useful though it has such a bad performance (compared to the array) in accessing data by index. We will introduce the insert and delete operations in next two articles and you will realize the benefit of the linked list.

After that, we provide an exercise for you to design your own singly linked list.


ADD Operation - O(1)

If we want to add a new value after a given node prev, we should: 

1. Initialize a new node cur with the given value
2. Link the "next" field of cur to prev's next node next
3. Link the "next" field in prev to cur.

Unlike an array, we don’t need to move all elements past the inserted element. 
Therefore, you can insert a new node into a linked list in O(1) time complexity, which is very efficient.


ADD NODE Beginning Operation - O(1)

As we know, we use the head node head to represent the whole list.
So it is essential to update head when adding a new node at the beginning of the list.

1. Initialize a new node cur;
2. Link the new node to our original head node head.
3. Assign cur to head.

ADD NODE End Operation - Worst Case O(N)

If we are given the tail, then 
1. Initialize a new node cur
2. Set the tails next value to cur

This would be O(1)

If we are not given the tail, then
1. Initialize a new node cur
2. Iterate through all nodes until we find the last value of list (its next value will be null)
3. Set the next value of this last node to the new node cur.

The process of this iteration entails an O(N) solution.



DELETE Operation - Worst Case O(N)

If we want to delete an existing node cur from the singly linked list, we can do it in two steps:
1. Find cur's previous node prev and its next node next
2. Link prev to cur's next node next

In our first step, we need to find out prev and next. It is easy to find out next using the reference field of cur. 
However, we have to traverse the linked list from the head node to find out prev which will take O(N) time on average, where N is the length of the linked list. So the time complexity of deleting a node will be O(N).

The space complexity is O(1) because we only need constant space to store our pointers.




DELETE FIRST NODE Operation - O(1)

If we want to delete the first node, the strategy will be a little different.

1. As we mentioned before, we use the head node head to represent a linked list. 
2. If we want to delete the first node, we can simply assign the next node to head. 


DELETE LAST NODE Operation - O(N)

1. Iterate to the tail (node where next value is null)
2. Assign the tail as null