package class_07;

public class Code_01_TrieTree {

	public static class TrieNode {
//		path：有多少字符串到达过这个节点
		public int path;
//		end：有多个字符串是以这个结尾的
		public int end;
		public TrieNode[] nexts;

		public TrieNode() {
			path = 0;
			end = 0;
//			准备了从头结点到A-Z的26条路
			nexts = new TrieNode[26];
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			if (word == null) {
				return;
			}
//			把word转换为字符类型的数组
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
//				如果chs[i]是a，index为0，如果是b，index为1，就是ASCII码的差值
				index = chs[i] - 'a';
//				判断当前node有没有走向当前字母的路，如果没有建一个，有不用管，继续往下执行
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
//				node跳到下一个结点
				node = node.nexts[index];
//				当前node的path++
				node.path++;
			}
			node.end++;
		}

		public void delete(String word) {
//			先查一下word存在不存在
			if (search(word) != 0) {
//				大体逻辑还是我怎么插的就怎么删
				char[] chs = word.toCharArray();
				TrieNode node = root;
				int index = 0;
				for (int i = 0; i < chs.length; i++) {
					index = chs[i] - 'a';
//					如果减到某个节点，它的path减完已经为0了，那么往下就不用看了，直接为空
					if (--node.nexts[index].path == 0) {
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}
		}
		//插入过多少次这个word
		public int search(String word) {
			if (word == null) {
				return 0;
			}
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}
//		查某个字符串前缀数量是多少
		public int prefixNumber(String pre) {
			if (pre == null) {
				return 0;
			}
			char[] chs = pre.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chs[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;
		}
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));

	}

}
