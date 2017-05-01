/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */
public class SubTreeWithMaxAverage {
	/**
	 * @param root
	 *            the root of binary tree
	 * @return the root of the maximum average of subtree
	 */
	private static ResultData emptyResultData = new ResultData(0, 0);
	private TreeNode result = null;
	private ResultData resultData = null;

	public TreeNode findSubtree2(TreeNode root) {
		if (root == null)
			return null;
		findMaxAverage(root);
		return result;
	}

	private ResultData findMaxAverage(TreeNode root) {
		if (root == null)
			return emptyResultData;
		ResultData leftResult = findMaxAverage(root.left);
		ResultData rightResult = findMaxAverage(root.right);
		int currentNum = leftResult.nodeNum + rightResult.nodeNum + 1;
		int currentSum = leftResult.nodeSum + rightResult.nodeSum + root.val;
		ResultData currentResult = new ResultData(currentNum, currentSum);

		if (result == null || resultData.nodeSum * currentResult.nodeNum >= resultData.nodeNum * currentResult.nodeSum) {
			result = root;
			resultData = currentResult;
		}

		return currentResult;

	}

	private static class ResultData {
		public int nodeNum;
		public int nodeSum;

		public ResultData(int nodeNum, int nodeSum) {
			this.nodeNum = nodeNum;
			this.nodeSum = nodeSum;
		}

	}
}