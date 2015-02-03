import java.util.ArrayList;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {  
	    if(root==null)  
	        return 0;  
	    ArrayList<Integer> res = new ArrayList<Integer>();  
	    res.add(Integer.MIN_VALUE);  
	    helper(root,res);  
	    return res.get(0);  
	}  
	private int helper(TreeNode root, ArrayList<Integer> res) {
	    if(root == null)  
	        return 0;  
	    int left = Math.max(0,helper(root.left, res));  
	    int right = Math.max(0,helper(root.right, res));  
	    int cur = root.val + left+right;  
	    if(cur>res.get(0))  
	        res.set(0,cur);  
	    return root.val+Math.max(left,right);  
	}  
}
