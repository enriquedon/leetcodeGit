public class SingleNumber2 {

	public static int singleNumber(int[] A) {
		int ones = 0, twos = 0, three = 0;
		for (int i = 0; i < A.length; i++) {
			System.out.println("ones ^ A:" + (ones ^ A[i]) + " twos ^ A:"
					+ (twos ^ A[i]));
			ones = (ones ^ A[i]) & ~twos & ~three;

			twos = (twos ^ A[i]) & ~ones & ~three;
			three = (three ^ A[i]) & ~ones & ~twos;

			
		}
		System.out.println("ones:" + (ones) + " twos:" + (twos) + " three:"
				+ three);
		return twos;
	}

	public static void main(String args[]) {
		int[] A = new int[100];
		for (int i = 1; i < 25; i++) {
			//A[i] = 11;
			//if (i != 11) {
				A[i] = i;
				A[i + 25] = i;
				A[i + 50] = i;
				A[i + 75] = i;
			//}
			A[1] = 33;
			A[26] = 44;
			A[51] = 44;
			A[76] = 44;
			//A[0] = 11;
			// A[100]=11;
		}
		int one = singleNumber(A);
		System.out.println(A[51]);
		System.out.println(one);
	}
}
