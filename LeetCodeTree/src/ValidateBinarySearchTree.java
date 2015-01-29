
public class ValidateBinarySearchTree {
	 public static boolean isValidBST(TreeNode root) {
	        return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	    }
	    private static boolean isValid(TreeNode root, int min, int max){
	    	
	        if(root==null) return true;
	        if(root.val == Integer.MIN_VALUE && root.left != null) return false;
	        if(root.val == Integer.MAX_VALUE && root.right != null) return false;
	        if(root.val>max||root.val<min) return false;
	        System.out.println("root.val:"+root.val);
	        return isValid(root.right,root.val+1,max)&&isValid(root.left,min,root.val-1);
	    }
	    public static void main(String args[]) {
			TreeNode rootNode=new TreeNode(Integer.MIN_VALUE);
			rootNode.right=new TreeNode(Integer.MAX_VALUE);
			System.out.println(isValidBST(rootNode));
		}
}
