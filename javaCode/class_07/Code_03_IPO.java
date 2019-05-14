package class_07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_03_IPO {
	public static class Node {
		public int p;
		public int c;

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}
//	MinCostComparator：花费低的比较器，谁的花费低谁放在堆的上面

	public static class MinCostComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}

	}
//	MaxProfitComparator：利润高的比较器，谁的利润高谁放在堆的上面
	public static class MaxProfitComparator implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			return o2.p - o1.p;
		}

	}

	public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
//		nodes就放我所有的项目
		Node[] nodes = new Node[Profits.length];
		for (int i = 0; i < Profits.length; i++) {
//			一个项目，两个维度，一个是项目的收益，一个是项目的花费
			nodes[i] = new Node(Profits[i], Capital[i]);
		}
//		花费小根堆
		PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
//		利润大根堆
		PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
		for (int i = 0; i < nodes.length; i++) {
//			把所有项目放到小根堆中去
			minCostQ.add(nodes[i]);
		}
//		这个for是限制我最多做k个项目
		for (int i = 0; i < k; i++) {
//			minCostQ.peek().c <= W：如果小根堆堆顶的钱小于w，说明小根堆堆顶的项目是我可以做的
			while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
//				小根堆里面的项目弹出一个，进入按照利润大小的大根堆中
				maxProfitQ.add(minCostQ.poll());
			}
//			有可能做不到k个项目就得停
			if (maxProfitQ.isEmpty()) {
				return W;
			}
//			得到所有项目中收益最好的项目的钱
			W += maxProfitQ.poll().p;
		}
		return W;
	}

}
