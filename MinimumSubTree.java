
public class MinimumSubTree {

	public static void main(String[] args) {

	}

	private TreeNode result = null;
	private int min = Integer.MAX_VALUE;

	public TreeNode findSubtree(TreeNode root) {
		if (root == null)
			return null;
		helper(root);
		return result;
	}

	private int helper(TreeNode root) {
		if (root == null)
			return 0;
		int leftSum = helper(root.left);
		int rightSum = helper(root.right);
		int totalSum = leftSum + rightSum + root.val;
		if (totalSum < min) {
			min = totalSum;
			result = root;
		}
		return totalSum;

	}

}
