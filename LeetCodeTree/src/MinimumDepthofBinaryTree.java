import java.util.Queue;
import java.util.LinkedList;

public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
        int min=0;
        Queue<TreeNode> nodes=new LinkedList<TreeNode>();
        if(root==null) return min;
        nodes.add(root);
        while(nodes.size()>0){
            min++;
            int currentNodes=nodes.size();
            while(currentNodes>0){
                TreeNode parent=nodes.poll();
                System.out.println("parent.val:"+parent.val);
                if(parent.left==null&&parent.right==null) return min;
                if(parent.left!=null){
                    nodes.add(parent.left);
                }
                if(parent.right!=null){
                    nodes.add(parent.right);
                }
                currentNodes--;
            }
            System.out.println("min:"+min);
        }
        return min;
    }
	public static void main(String args[]){
		TreeNode one = new TreeNode(4);
		TreeNode two = new TreeNode(9);
		TreeNode three = new TreeNode(0);
		TreeNode four = new TreeNode(1);
		one.left = two;
		one.right = three;
		two.right = four;
		MinimumDepthofBinaryTree ssLeafNumbers = new MinimumDepthofBinaryTree();
		System.out.println(ssLeafNumbers.minDepth(one));
	}
}
