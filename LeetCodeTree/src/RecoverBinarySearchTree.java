public class RecoverBinarySearchTree {
	TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
	TreeNode first = null;
	TreeNode second = null;
	TreeNode successorfirst = null;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;

		traverseTree(root);
		System.out.println(first.val);
		System.out.println(successorfirst.val);
		int tmp = first.val;
		if (second == null) {
			first.val = successorfirst.val;
			successorfirst.val = tmp;
		} else {
			first.val = second.val;
			second.val = tmp;
		}
	}

	public void traverseTree(TreeNode node) {

		if (node == null)
			return;

		traverseTree(node.left);

		// if( preNode.val > node.val ) {
		// if( first == null ) {
		// first = preNode;
		// successorfirst = node;
		// }else {
		// if( preNode == successorfirst||preNode.val > successorfirst.val ) {
		// second = node;
		// }else {
		// second = preNode;
		// return;
		// }
		// }
		// }
		if (preNode.val > node.val) {
			if (first == null) {
				first = preNode;
				successorfirst = node;
			} else {
				second = node;
				return;
			}
		}
		preNode = node;

		traverseTree(node.right);
	}

	public static void main(String args[]) {
		TreeNode a = new TreeNode(5);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(6);
		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(7);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;

		RecoverBinarySearchTree ssLeafNumbers = new RecoverBinarySearchTree();
		ssLeafNumbers.recoverTree(a);
	}
}
