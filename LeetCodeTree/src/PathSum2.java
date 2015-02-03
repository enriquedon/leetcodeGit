

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSum2 {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> path = new ArrayList<Integer>();
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		if (root == null)
			return result;

		nodes.push(root);
		int value = 0;
		int init = 0;
		while (path.size() > 0 || init == 0) {
			init = 1;
			while (nodes.size() >= path.size()) {
				TreeNode parent = nodes.pop();
				if (parent == null)
					continue;
				path.add(parent.val);
				value += parent.val;

				if (parent.right == null && parent.left == null) {
					if (value == sum) {

//						List<Integer> temp = new ArrayList<Integer>();
//						for (int j : path) {
//							temp.add(j);
//						}
						result.add(new ArrayList<Integer>(path)); 
						// System.out.println("------path-----");
						// for(int j:path){
						// System.out.print(j);
						// }
						// System.out.println();
						// System.out.println("------path-----");
					}
					break;
				}
				nodes.push(parent.right);
				nodes.push(parent.left);
			}
			value -= path.remove(path.size() - 1);
		}

		return result;
	}

	public static void main(String args[]) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.left = b;
		b.left = c;
		c.left = d;
		d.left = e;
		List<List<Integer>> result = pathSum(a, 15);
		System.out.print("[");
		for (List<Integer> i : result) {
			System.out.print("[");
			for (int j : i) {
				System.out.print(j);
			}
			System.out.print("],");
		}
		System.out.print("]");
	}
}
