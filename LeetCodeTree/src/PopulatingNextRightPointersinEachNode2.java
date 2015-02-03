import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode2 {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> parent = new LinkedList<TreeLinkNode>();
		root.next = null;
		parent.add(root);
		int currentNodes = 1;
		while (parent.size() > 0) {
			while (currentNodes > 0) {
				TreeLinkNode temp = parent.poll();
				if (temp.left != null) {
					parent.add(temp.left);
					System.out.println("temp.left:" + temp.left.val);
				}
				if (temp.right != null) {
					parent.add(temp.right);
					System.out.println("temp.right:" + temp.right.val);
				}
				currentNodes--;
			}
			Queue<TreeLinkNode> stack = new LinkedList<TreeLinkNode>();
			while (parent.size() > 0) {
				TreeLinkNode temp = parent.poll();
				temp.next = parent.peek();
				if (parent.size() > 0) {
					System.out.println(temp.val + "---->"
							+ parent.peek().val);
				}

				// System.out.println(parent.size()+" "+stack.size());
				stack.add(temp);
			}
			while (stack.size() > 0) {
				parent.add(stack.poll());
			}
			currentNodes = parent.size();
		}
	}

	public static void main(String args[]) {
		TreeLinkNode a = new TreeLinkNode(5);
		TreeLinkNode b = new TreeLinkNode(2);
		TreeLinkNode c = new TreeLinkNode(6);
		TreeLinkNode d = new TreeLinkNode(1);
		TreeLinkNode e = new TreeLinkNode(3);
		TreeLinkNode f = new TreeLinkNode(4);
		TreeLinkNode g = new TreeLinkNode(7);
		a.left = b;
		a.right = c;
		b.left = d;
		//b.right = e;
		c.left = f;
		c.right = g;
		PopulatingNextRightPointersinEachNode2 ssLeafNumbers = new PopulatingNextRightPointersinEachNode2();
		ssLeafNumbers.connect(a);
	}
}
