import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> outcome = new ArrayList<Integer>();
		LinkedList<TreeNode> path = new LinkedList<TreeNode>();
		path.add(root);
		while (path.size() != 0) {
			TreeNode temp = path.pop();
			if (temp != null) {
				outcome.add(temp.val);
				if (temp.right != null) {
					path.push(temp.right);
				}
				if (temp.left != null) {
					path.push(temp.left);
				}
			}
		}

		return outcome;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
