import java.util.LinkedList;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.push(root);
		int currentNodes = 1;
		//int tempSum = 0;
		while (nodes.size() > 0) {
			while (currentNodes > 0) {
				TreeNode tempNode = nodes.pop();

				if (tempNode.left != null) {
					tempNode.left.val = tempNode.val + tempNode.left.val;
					System.out.println(tempNode.left.val);
					nodes.push(tempNode.left);
				}
				if (tempNode.right != null) {
					tempNode.right.val = tempNode.val  + tempNode.right.val;
					nodes.push(tempNode.right);
					System.out.println(tempNode.right.val);
				}
				if (tempNode.left == null && tempNode.right == null) {
					if(sum == tempNode.val){
						return true;
					}
				}
				System.out.println("currentNode:" + currentNodes);
				currentNodes--;
			}
			currentNodes = nodes.size();
		}
		return false;
	}
	
	public static void main(String args[]) {
		TreeNode one = new TreeNode(4);
		TreeNode two = new TreeNode(9);
		TreeNode three = new TreeNode(0);
		TreeNode four = new TreeNode(1);
		one.left = two;
		one.right = three;
		two.right = four;
		PathSum ssLeafNumbers = new PathSum();
		System.out.println(ssLeafNumbers.hasPathSum(one,14));
	}
}
