public class test {

	public static void main(String args[]) {
		int[] count = { 1, 2, 3, 4, 5 };
		change(count);
		System.out.println(count[0]);
	}

	private static void add(A a) {
		a = new A();
		a.i++;

	}

	public static void change(int[] counts) {
		counts[0] = 6;
		System.out.println(counts[0]);
	}
}

class A {
	int i = 0;
}