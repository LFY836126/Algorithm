package class_04;

public class Code_08_CompleteTreeNodeNumber {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}
//	node是当前结点的意思。l是指node在第几层，h是全局变量，是整个node的深度，返回值是以node为头的整棵树的节点个数
	public static int bs(Node node, int l, int h) {
//		代表当前节点是叶结点，返回结点数为1
		if (l == h) {
			return 1;
		}
//		mostLeftLevel(node.right, l + 1)：求node右子树的左边界到了哪一层，和我整体最深的深度是不是相等的
		if (mostLeftLevel(node.right, l + 1) == h) {
//			1 << (h - l)) <==> 2^(h - l)：就是求我左子树加我自己一个多少个结点
//			bs(node.right, l + 1, h)：求以node为头的整体二叉树结点个数
			return (1 << (h - l)) + bs(node.right, l + 1, h);
		} else {
//			此时我右树是一个完全二叉树，并且高度为h - l
			return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
		}
	}

	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		System.out.println(nodeNum(head));

	}

}
