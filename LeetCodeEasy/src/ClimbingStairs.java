public class ClimbingStairs {
	public static int climbStairs(int n) {
		if (n < 3)
			return n;
		int[] temp = new int[n + 1];
		temp[0] = 0;
		temp[1] = 1;
		temp[2] = 2;
		for (int i = 3; i < n + 1; i++) {
			temp[i] = temp[i - 1] + temp[i - 2];
		}
		return temp[n];
	}

	public static void main(String args[]) {
		System.out.println(climbStairs(5));
	}
}
