
public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p != null && q != null) {
			if (p.val == 1 && q.val == 1) {
				return false;
			}
		}
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}

		boolean a = isSameTree(p.left, p.left);
		if (!a) {
			return false;
		}
		boolean b = isSameTree(p.right, p.right);
		if (!b) {
			return false;
		}
		return true;
	}
	
	boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else if (p != null && q != null) {
            return ((p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        }
        else
            return false;
    }
}



