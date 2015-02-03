import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversalR(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		doo(root, result);
		return result;
	}

	private void doo(TreeNode root, List<Integer> result) {
		if (root == null)
			return;
		doo(root.left, result);
		doo(root.right, result);
		result.add(root.val);
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		if (root != null) {
			nodes.push(root);
		}
		while (nodes.size() > 0) {
			TreeNode parent = nodes.pop();
			result.add(parent.val);
			if (parent.left != null) {
				nodes.push(parent.left);
			}
			if (parent.right != null) {
				nodes.push(parent.right);
			}
		}
		Collections.reverse(result);
		return result;
	}

	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		for (int c : numbers) {
			int remain = target - c;
			if (map.containsKey(remain)) {
				result[0] = map.get(c);
				result[1] = map.get(remain);
				return result;
			}
		}

		return result;
	}
}