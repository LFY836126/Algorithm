package class_07;

import java.util.Arrays;
import java.util.Comparator;

public class Code_05_LowestLexicography {

	public static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {/*返回负数代表参数小，返回正数代表后面的数更小*/
			return (a + b).compareTo(b + a);
		}
	}

	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
//		sort按照我定义的比较器的方式进行比较
		Arrays.sort(strs, new MyComparator());
		String res = "";
//		拼接数组中所有字符串
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs1));

		String[] strs2 = { "ba", "b" };
		System.out.println(lowestString(strs2));
	}

}
