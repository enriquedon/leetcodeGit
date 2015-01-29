public class UniqueBinarySearchTrees {

public class Solution {
    public int numTrees(int n) {
        int[] N = new int[n + 1];
        N[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                N[i] += N[j] * N[i - j - 1];
            }
        }
        return N[n];
    }
}
	public static void main(String args[]) {

	}
}
