# Introduction - Doubly Linked List.

We have introduced the singly linked list in previous chapters.
> A node in a singly linked list has the value field, and a "next" reference field to link nodes sequentially.
In this article we will introduce another type of linked list: `Doubly Linked List`

# Definition

The doubly linked list works in a similar way but has one more reference field which is known as the "prev" field. With this extra field, you are able to know the previous node of the current node.

# Node Structure

Here is a typical definition of the node structure in a doubly linked list:
``` java
class DoublyListNode {
    int val;
    DoublyListNode next, prev;
    DoublyListNode(int x) {val = x;}
}
```
Similar to the singly linked list, we will use the head node to represent the whole list.

# Operations

Similar to a singly linked list, we will introduce how to access data, insert a new node or delete an existing node in a doubly linked list.

We can access data in the same exact way as in a singly linked list:

1. We are `not able to access a random position` in constant time.
2. We have to `traverse from the head` to get the `i-th` node we want.
3. The time complexity in the worse case will be `O(N)`, where `N` is the length of the linked list.

For addition and deletion, it will be a little more complicated since we need to take care of the "prev" field as well. We will go through these two operations in next two articles.

After that, we provide an exercise for you to redesign the linked list using doubly linked list.


# Operation - ADD

If we want to insert a new node cur after an existing node prev, we can divide this process into two steps:

1. link `cur` with `prev` and `next`, where `next` is the original next node of `prev`;
2. re-link the `prev` and `next` with `cur`.

Similar to the singly linked list, both the time and the space complexity of the add operation are `O(1)`.

# Operation - ADD - An Example

Let's add a new node 9 after the existing node 6:

1. link `cur` (node 9) with `prev` (node 6) and `next` (node 15)
2. re-link `prev` (node 6) and `next` (node 15) with `cur` (node 9)

Note:  if we want to insert a new node at the beginning or at the end, must account for pointing to null!


# Operation - DELETE

If we want to delete an existing node `cur` from the doubly linked list, we can simply link its previous node `prev` with its next node `next`.

> Unlike the singly linked list, it is easy to get the previous node in constant time with the "prev" field.

Since we no longer need to traverse the linked list to get the previous node, both the time and space complexity are `O(1)`.

# Operation - DELETE - An Example

Our goal is to delete the node 6 from the doubly linked list.
So we link its previous node 23 and its next node 15:

Node 6 is not in our doubly linked list now.

Note:  if we want to delete the first node or the last node




