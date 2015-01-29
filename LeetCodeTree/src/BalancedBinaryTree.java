import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalancedBinaryTree {
	static LinkedList<TreeNode> node1 = new LinkedList<TreeNode>();
	static LinkedList<TreeNode> node2 = new LinkedList<TreeNode>();
	static int level = 0;
	static int min = 0;

	public static boolean isBalanced2(TreeNode root) {
		if (root == null)
			return true;
		int min = 0;
		int max = 0;
		Queue<TreeNode> bfs = new LinkedList<TreeNode>();
		bfs.add(root);
		int count = 1;
		int next = 0;
		while (bfs.size() != 0) {
			TreeNode parent = bfs.poll();
			count--;

			if (parent.left != null) {
				bfs.add(parent.left);
				next++;
			}
			if (parent.right != null) {
				bfs.add(parent.right);
				next++;
			}
			if (count == 0) {
				max++;
				count = next;
				next = 0;
			}
			if (parent.left == null || parent.right == null) {
				min = min == 0 ? max : min;
			}
			System.out.println("min:" + min + "max:" + max);
		}
		return max - min < 2;
	}

	public static boolean isBalanced(TreeNode root) {

		if (root == null) {
			return true;
		}

		node1.push(root);
		while (!node1.isEmpty()) {
			level++;
			turnAround(node1, node2);

			if (!node2.isEmpty()) {
				level++;
				turnAround(node2, node1);

			}

		}
		System.out.println("level:" + level);
		System.out.println("min:" + min);
		if (level - min > 1) {
			return false;
		}
		return true;
	}

	public static void turnAround(LinkedList<TreeNode> node1,
			LinkedList<TreeNode> node2) {
		while (!node1.isEmpty()) {
			TreeNode parent = node1.poll();
			if (parent.left != null) {
				node2.push(parent.left);
			}
			if (parent.right != null) {
				node2.push(parent.right);
			}
			if ((parent.left == null || parent.right == null) && min == 0) {
				min = level;
			}

		}
	}

	public static void main(String args[]) {
		TreeNode rootNode = new TreeNode(1);
		TreeNode Node1 = new TreeNode(2);
		TreeNode Node2 = new TreeNode(2);
		TreeNode Node3 = new TreeNode(3);
		TreeNode Node4 = new TreeNode(3);
		TreeNode Node5 = new TreeNode(3);
		TreeNode Node6 = new TreeNode(3);
		TreeNode Node7 = new TreeNode(4);
		TreeNode Node8 = new TreeNode(4);
		rootNode.right = Node1;
		// rootNode.left = Node2;
		// Node1.left = Node3;
		Node1.right = Node4;
		// Node2.left = Node5;
		// Node2.right = Node6;
		// Node3.left = Node7;
		// Node3.right = Node8;
		System.out.println(isBalanced2(rootNode));
	}
}
