import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConvertSortedArraytoBinarySearchTree {

	public static TreeNode sortedArrayToBST(int[] num) {
		double size = num.length;
		int number = num.length;
		boolean[] signal = new boolean[(int) size];
		Stack<TreeNode> NodeStack = new Stack<TreeNode>();
		Stack<Integer> PositionStack = new Stack<Integer>();
		if (size == 0) {
			return null;
		}
		int offset = (int) Math.floor(size / 2);
		signal[offset] = true;
		TreeNode root = new TreeNode(num[offset]);
		NodeStack.push(root);
		PositionStack.push(offset);
		number--;
		while (number > 0) {
			TreeNode tempRootNode = NodeStack.pop();
			System.out.println("number:" + number + " NodeStack.size():"
					+ NodeStack.size() + " PositionStack.size():"
					+ PositionStack.size());
			if (PositionStack.size() > 0) {
				offset = PositionStack.pop();
			}
			int temp = 0;
			if (offset >= (int) Math.floor(size / 2)) {
				temp = (int) Math.floor((size - offset) / 2);
			} else {
				if (offset == 1) {
					temp = 1;
				} else {
					temp = (int) Math.floor(offset / 2);
				}
			}

			int offset1 = offset - temp;
			int offset2 = offset + temp;
			System.out.println("offset:" + offset + " temp:" + temp
					+ " offset1:" + offset1 + " offset2:" + offset2);
			if (signal[offset1] == false) {
				tempRootNode.left = new TreeNode(num[offset1]);
				PositionStack.push(offset1);
				signal[offset1] = true;
				NodeStack.push(tempRootNode.left);
				number--;
				System.out.println("num[offset1]:" + num[offset1]);
			}
			if (signal[offset2] == false) {
				tempRootNode.right = new TreeNode(num[offset2]);
				PositionStack.push(offset2);
				signal[offset2] = true;
				NodeStack.push(tempRootNode.right);
				number--;
				System.out.println("num[offset2]:" + num[offset2]);
			} 

		}
		return root;
	}

	static void PrintTree(TreeNode root) {
		Queue<TreeNode> treeQueue1 = new LinkedList<TreeNode>();
		Queue<TreeNode> treeQueue2 = new LinkedList<TreeNode>();
		System.out.println(root.val + " ");
		treeQueue1.add(root);
		BFSprint(treeQueue1, treeQueue2);
	}

	private static void BFSprint(Queue<TreeNode> treeQueue1,
			Queue<TreeNode> treeQueue2) {
		TreeNode temp;
		int ParentOfLeaves = treeQueue1.size();
		while (!treeQueue1.isEmpty()) {
			temp = treeQueue1.poll();
			if (temp.left != null) {
				System.out.print(temp.left.val + " ");
				treeQueue2.add(temp.left);
			} else
				System.out.print("* ");

			if (temp.right != null) {
				treeQueue2.add(temp.right);
				System.out.print(temp.right.val + " ");
			} else
				System.out.print("* ");
			if (temp.left == null && temp.right == null) {
				ParentOfLeaves--;
			}

			if (ParentOfLeaves == 0)
				return;
		}
		System.out.println();
		BFSprint(treeQueue2, treeQueue1);
		// add parent node into Queue1 and add two children into Queue2 when
		// poll it out
	}

	public static void main(String args[]) {
		int[] num = new int[4];
		for (int i = 0; i < 4; i++) {
			num[i] = i + 1;
		}
		num[0]=-1;
		num[1]=0;
		num[2]=1;
		num[3]=2;
		
		TreeNode root = sortedArrayToBST(num);
		PrintTree(root);
	}
}
