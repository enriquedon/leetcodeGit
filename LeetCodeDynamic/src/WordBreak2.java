import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
	private static List<String> res = new ArrayList<String>();

	public List<String> wordBreak(String s, Set<String> dict) {
		// StringBuilder solution = new StringBuilder();
		if (s == null || dict.size() == 0) {
			return res;
		}
		
		boolean[] possible = new boolean[s.length() + 1];
		Arrays.fill(possible, true);
//		for(boolean a:possible){
//			System.out.println(a);
//		}
		wordBreakItr(s, dict, "", possible);
		printres();
		return res;
	}

	private void printres() {
		System.out.println(res.size());
//		for (String s : res) {
//			System.out.println(s);
//		}

	}

	private void wordBreakItr(String s, Set<String> dict, String solution,
			boolean[] possible) {
		StringBuilder wordBuilder = new StringBuilder();
		// System.out.println(solution.toString());
		String tempWord;
		for (int i = 0; i < s.length(); i++) {
			wordBuilder.append(s.charAt(i));
			tempWord = wordBuilder.toString();
			if (dict.contains(tempWord) && possible[i + 1]) {
//				System.out.println(solution.toString());
				String newItem = solution.length() > 0 ? (solution + " " + tempWord)
						: tempWord; // ?????
				int size = res.size();

				if (i == s.length() - 1) {
					newItem.trim();
					res.add(newItem);
//					System.out.println(newItem);
				} else {
					wordBreakItr(s.substring(i + 1), dict, newItem, possible);
				}
				if (size == res.size()) {
					possible[i + 1] = false;
					System.out.println("Set:"+i+" to false");
				}
				// solution.substring(0,preLen);
				// System.out.println(solution.toString());
			}
		}
	}

	public static void main(String args[]) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		 dict.add("a");
		// dict.add("ddog");
		WordBreak2 test = new WordBreak2();
		test.wordBreak(s, dict);
	}

}

class test {
	int a = 0;
	List<String> s = new ArrayList<String>();

	test(int a, ArrayList<String> s) {
		this.a = a;
		this.s = s;
	}

	void addArray(String str) {
		s.add(str);
	}

	void setNum(int i) {
		a = i;
	}

	int getArraySize() {
		return s.size();
	}
}