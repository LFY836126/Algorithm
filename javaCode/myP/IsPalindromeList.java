package myP;
import java.util.Stack;
public class IsPalindromeList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }
    /*1.利用额外空间（空间复杂度为O(n)），将链表的全部数据压到栈里，然后从头节点开始和栈每次弹出的数进行比对，有不一样的，就返回false*/
    // need n extra space
    public static boolean isPalindrome1(Node head) {
        Stack<Node> stack = new Stack<Node>();
        Node cur =  head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    /*2.利用额外空间（空间复杂度为O(n)），用两个指针，快指针一次跑两个，慢指针一次一个，当快指针走到了结尾，慢指针走到中点的位置
    链表的后半部分数据压到栈里，然后从头节点开始和栈每次弹出的数进行比对，有不一样的，就返回false*/
    // need n/2 extra space
    public static boolean isPalindrome2(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        Node fast = head;//为什么视频上是fast = head.next ?
        Node cur = head;
        while(cur.next != null && cur.next.next != null){
            fast = fast.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while(fast!= null){
            stack.push(fast);
            fast = fast.next;
        }
        while(!stack.isEmpty()){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public static boolean isPalindrome3(Node head){
        if(head == null || head.next == null){
            return false;
        }
        Node n1 = head;//慢指针
        Node n2 = head;//快指针
        while (n2.next != null && n2.next.next != null) { // find mid node
            n1 = n1.next; // n1 -> mid
            n2 = n2.next.next; // n2 -> end
        }

        n2 = n1.next; //n2 = n1.next是差不多改变遍历的位置，要是n1.next = n2 那就是改变链表指针了
        n1.next = null;
        Node n3 = null;
        /*下面的while，就是将后半部分链表改变指针方向,执行完结果就是类似于1->2->3<-２<-1 */
        while (n2 != null) { // right part convert
            n3 = n2.next; // n3 -> save next node
            n2.next = n1; // next of right node convert
            n1 = n2; // n1 move
            n2 = n3; // n2 move
        }

        n3 = n1;/*将n1预先存在n3中，后面的归位要用到*/
        n2 = head;
        boolean res = true;
        while(n2 != null && n1 != null){
            if(n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        /*下面的while，将链表后半部分指针归位，执行完结果就是1->2->3->2->1*/
        n1 = n3.next;
        n3.next = null;
        while(n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String [] args){
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.print(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");
    }
}
