package class_05;

import java.util.HashMap;
import java.util.List;

public class Code_04_UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap;	/*Key: child, value: father*/
		public HashMap<Node, Integer> sizeMap;	/*某一个代表节点所在的集合一共有多少个节点*/

		public UnionFindSet(List<Node> nodes) {
//			List<Node> nodes：初始化时候，让用户一次性的把所有样本给你
			makeSets(nodes);
		}
		private void makeSets(List<Node> nodes) {
			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
			for (Node node : nodes) {
//				自己指向自己，每个节点代表节点都是自己，父节点也都是自己
				fatherMap.put(node, node);
//				size也就是1
				sizeMap.put(node, 1);
			}
		}
//		找到元素代表节点,并且变扁平
		private Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
