public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		int tempSum = 0;
		int sum = 0;
		if (A.length != 0) {
			sum = A[0];
			tempSum = A[0];
			for (int i = 1; i < A.length; i++) {
				if (tempSum < 0 && tempSum < A[i]) {
					tempSum = 0;
				}
				tempSum += A[i];
				sum=Math.max(sum, tempSum);
			}
		}
		return sum;
	}
}
