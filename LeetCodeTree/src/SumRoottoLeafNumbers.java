import java.util.LinkedList;

public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.add(root);
		int currentNodes = 1;
		int sum = 0;
		while (nodes.size() > 0) {
			while (currentNodes > 0) {
				TreeNode tempNode = nodes.poll();

				if (tempNode.left != null) {
					tempNode.left.val = tempNode.val * 10 + tempNode.left.val;
					System.out.println(tempNode.left.val);
					nodes.add(tempNode.left);
				}
				if (tempNode.right != null) {
					tempNode.right.val = tempNode.val * 10 + tempNode.right.val;
					nodes.add(tempNode.right);
					System.out.println(tempNode.right.val);
				}
				if (tempNode.left == null && tempNode.right == null) {
					sum += tempNode.val;
				}
				System.out.println("currentNodes:" + currentNodes);
				currentNodes--;
			}
			currentNodes = nodes.size();
		}
		return sum;
	}

	public static void main(String args[]) {
		TreeNode one = new TreeNode(4);
		TreeNode two = new TreeNode(9);
		TreeNode three = new TreeNode(0);
		TreeNode four = new TreeNode(1);
		one.left = two;
		one.right = three;
		two.right = four;
		SumRoottoLeafNumbers ssLeafNumbers = new SumRoottoLeafNumbers();
		System.out.println(ssLeafNumbers.sumNumbers(one));
	}
}
