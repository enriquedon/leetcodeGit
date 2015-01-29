public class BestTimetoBuyandSellStock2 {
	public static int maxProfit(int[] prices) {
		int profit = 0;
		int sell = 0;
		int buy = 999999;
		int current = 0;
		for (int i = 0; i < prices.length; i++) {

			int incoming = 0;
			current = prices[i];
			if (i == prices.length - 1) {
				if (current > sell) {
					sell = current;
				}
				incoming = incoming = sell - buy;
				if (incoming > 0) {
					profit += incoming;
				}
				break;
			}
			if (current < sell) {
				incoming = sell - buy;
				buy = current;
				sell = current;
			}
			if (current < buy) {
				buy = current;
			}
			if (current > sell) {
				sell = current;
			}
			profit += incoming;
			// System.out.println(incoming);
		}
		return profit;
	}

	public static int maxProfit2(int[] prices) {
		if (prices.length == 0)
			return 0;
		int buy = prices[0];
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < buy) {
				buy = prices[i];
			}
			if (i == prices.length - 1) {
				if (prices[i] - buy > 0) {
					profit += prices[i] - buy;
				}
				return profit;
			}
			if (prices[i + 1] < prices[i] && prices[i] > buy) {
				profit += prices[i] - buy;
				buy = prices[i];
			}
		}
		return profit;
	}

	public static void main(String args[]) {
		int prices[] = new int[2];
		// for (int i = 0; i < 25; i++) {
		// if (i > 20) {
		// prices[i] = (i) * 3;
		// } else {
		// prices[i] = (44 - i) * 2;
		// if (i % 5 == 0) {
		// prices[i] = i;
		// }
		// }
		// }
		// prices[0] = 2;
		// prices[1] = 1;
		// prices[2] = 2;
		// prices[3] = 0;
		// prices[4] = 1;
		String a = "asds";
		prices[0] = 1;
		prices[1] = 2;
		int profit = maxProfit2(prices);
		System.out.println("!!" + profit);
	}
}
