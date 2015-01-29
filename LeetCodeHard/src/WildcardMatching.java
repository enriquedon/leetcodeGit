public class WildcardMatching {
	public static boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while (i < s.length()) {
			System.out.println(" s.charAt(i):"+s.charAt(i)+" charAt(j) :"+p.charAt(j));
			if (j < p.length()
					&& (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				star = j++;
				mark = i;
			} else if (star != -1) {
				j = star + 1;
				i = ++mark;
			} else {
				return false;
			}
			System.out.println(" i:"+i +" j:"+j);
		}
		//System.out.println("j:"+j+" star:"+star);
		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}
		return j == p.length();
	}

	public static void main(String[] args) {
		String s = "abcbea";
		String p = "a*bca";
		isMatch(s, p);
	}
}


