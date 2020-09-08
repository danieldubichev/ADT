import java.lang.Math;

public class Reverse {
    public static void main(String[] args){
        int max, min, range, rand;
        max = 10;
        min = 1;
        range = max - min + 1;
        rand = (int)(Math.random() * range) + min;
        ListNode Head = new ListNode(rand);
        ListNode Cur = new ListNode();

        for(int i = 0; i < 5; i++){
            if (Head.next == null){
                Cur.val = (int)(Math.random() * range) + min;
                Head.next = Cur;
            }
            else {
                ListNode NewNode = new ListNode((int)(Math.random() * range) + min);
                Cur.next = NewNode;
                Cur = NewNode;
            }
        }

        Cur = Head;
        
        //Recursive Solution
        /* 
        print(Cur);
        ListNode Test1 =  reverseRecursive1(Cur);     
        print(Test1);
        */

        //Iterative Solution
        print(Cur);
        ListNode Test2 = reverseList(Cur);
        System.out.println("reversed");
        print(Test2);


    }

    public static ListNode reverseList(ListNode cur){
        if (cur == null){ return null; }                            //check if input is empty
        ListNode head = new ListNode(cur.val);                      //create new Head Node
        while (cur.next != null ){                                  //iterate through list
            ListNode newHead = new ListNode(cur.next.val, head);    //next value in list has node created, and its next value was the last head in new list
            head = newHead;                                         //update the head of the new list; so we may point the next value to it
            cur = cur.next;                                         //move down the original list
        }
        return head;                                                //return the reversed list
    }


    public static ListNode reverseRecursive1(ListNode Head){
        ListNode newHead = new ListNode(Head.val);
        return reverseRecursive2(Head, newHead);
    }

    private static ListNode reverseRecursive2(ListNode Cur, ListNode newHead){
        if (Cur.next == null){
            return newHead;   
        } else {
            ListNode newerHead = new ListNode(Cur.next.val, newHead);
            return(reverseRecursive2(Cur.next, newerHead));
        }
    }

    public static void print(ListNode Cur){
        while (Cur != null){
            System.out.println(Cur.val);
            Cur = Cur.next;
        }
    }

}