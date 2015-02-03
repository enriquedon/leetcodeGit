public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs[0] == null)
			return null;
		int i = 0;
		while (i < strs[0].length()) {
			int j = 1;
			String temp = strs[0].substring(0, i + 1);
			while (j < strs.length) {
				if (!strs[j].startsWith(temp))
					return i == 0 ? null : strs[0].substring(0, i);
				j++;
			}
			i++;
			System.out.println(i);
		}
		return strs[0];
	}
	
	public static void main(String args[]){
		String string="a.b";
		String[] aStrings=string.split(".");
		for(String s:aStrings){
			System.out.print(s+",");
		}
		int a=3;
		int b=2;
		int c=(int) Math.ceil(a/b);
		System.out.println(c);
		System.out.println(longestCommonPrefix(aStrings));;
	}
}
