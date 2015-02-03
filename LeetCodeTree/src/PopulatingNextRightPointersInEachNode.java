import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		LinkedList<TreeLinkNode> parent = new LinkedList<TreeLinkNode>();
		while (true) {
			while (root != null) {
				parent.push(root);
				if (root.left != null) {
					root.left.next = root.right;
				}
				root = root.left;
			}
			if (parent.isEmpty())
				break;
			TreeLinkNode temp = parent.pop();

			if (temp.right != null) {
				if (temp.next != null) {
					temp.right.next = temp.next.left;
				} else {
					temp.right.next = null;
				}
			}
			root = temp.right;
		}
	}
}

