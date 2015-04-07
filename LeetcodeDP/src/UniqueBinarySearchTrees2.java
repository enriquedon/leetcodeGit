import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees2 {
	
	public List<TreeNode> generateTrees(int n) {
		
		return helper(1,n);
	}
	private List<TreeNode> helper(int left, int right) {
		List<TreeNode> res=new ArrayList<TreeNode>();
		if(left>=right){
			res.add(null);
			return res;
		}
		for (int i = left; i < right; i++) {
			List<TreeNode> leftList=helper(left, i-1);
			List<TreeNode> rightList=helper(i+1, right);
			for(int j=0;j<leftList.size();j++){
				for(int k=0;k<rightList.size();k++){
					TreeNode rootNode=new TreeNode(i);
					rootNode.left=leftList.get(j);
					rootNode.right=rightList.get(k);
					res.add(rootNode);
				}
			}
		}
		return res;
	}
}
