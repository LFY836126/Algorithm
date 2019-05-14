package class_07;

import java.util.Arrays;
import java.util.Comparator;

public class Code_06_BestArrange {

	public static class Program {
//		开始时间，结束时间
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
//	ProgramComparator： 谁结束时间更早谁排在上面
	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int cur) {
//		排序项目
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
//			如果我项目的开始时间是大于当前时刻的，项目数++， 当前时刻来到项目结束时刻
			if (cur <= programs[i].start) {
				result++;
				cur = programs[i].end;
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
