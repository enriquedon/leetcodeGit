public class HouseRobber {
	public int rob(int[] num) {
		int[] maxAmount = new int[num.length + 2];
		maxAmount[0] = 0;
		maxAmount[1] = 0;
		for (int hn = 0; hn < num.length; hn++) {
			maxAmount[hn + 2] = Math.max(maxAmount[hn + 1], maxAmount[hn]
					+ num[hn]);
		}

		return maxAmount[num.length + 2];

	}

	private void helper(int[] maxAmount, int[] num, int i) {

		for (int hn : num) {
			maxAmount[hn] = Math.max(maxAmount[hn - 1], maxAmount[hn - 2]
					+ num[hn]);
		}
	}
}
