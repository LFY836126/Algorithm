package class_03;

public class Code_14_FindFirstIntersectNode {

//	单链表结构
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
//主函数，判断单链表有环还是无环，不相交返回空，相交返回第一个相交的结点
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
//		得到两个有环链表各自第一个入环的结点
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		//		两个无环单链表相交的问题
		if (loop1 == null && loop2 == null) {
			//返回值为两个无环链表第一个相交的结点
			return noLoop(head1, head2);
		}
		//		两个有环单链表相交的问题
		if (loop1 != null && loop2 != null) {
		//传进两个链表的头结点和各自第一个相交的结点，返回值为两个有环链表第一个相交的结点
			return bothLoop(head1, loop1, head2, loop2);
		}
	//		一个有环，一个无环，不可能相交
		return null;
	}

	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next; // n1 -> slow
		Node n2 = head.next.next; // n2 -> fast
//		当快慢指针相遇时停止
		while (n1 != n2) {
//			如果快指针遇到空了，那么一定没环
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
//			快指针
			n2 = n2.next.next;
//			慢指针
			n1 = n1.next;
		}
//		快指针回到头
		n2 = head; // n2 -> walk again from head
//		两个指针相遇，停止，此时就是第一个相遇的结点
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	//		两个无环单链表相交的问题
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
//		n：两个链表长度的差值，cur1，和cur2:两个链表的end
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}
//		cur1取长度较长链表的头结点
		cur1 = n > 0 ? head1 : head2;
//		cur2取长度较短链表的头结点
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
//		长的先走
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
//		相遇跳出
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
//		返回第一个相遇的结点
		return cur1;
	}
	//		两个有环单链表相交的问题
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) {
//			loop1和loop2相等，那么重复两个无环单链表的相交问题的代码
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
//			否则 就为情况1或者情况3
		} else {
			cur1 = loop1.next;
//			loop1跑一圈看是否碰到过loop2，没有就是6 6 这样的第一种情况，否则就是第三种情况
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

}
