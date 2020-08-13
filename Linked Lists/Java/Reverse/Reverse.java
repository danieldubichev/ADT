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
        
        ListNode Bait = new ListNode();
        print(Cur);
        
        
        ListNode Test1 =  reverseRecursive1(Bait);
        
       
     
        print(Test1);




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