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
	public static NodeSum emptyNodeSum = new NodeSum(null, 0, 0);

	public TreeNode findSubtree2(TreeNode root) {
		if (root == null)
			return null;
		NodeSum result = new NodeSum(null, 0, 0);
		findMaxAverage(root, result);
		return result.node;
	}

	private NodeSum findMaxAverage(TreeNode root, NodeSum result) {
		if (root == null)
			return emptyNodeSum;
		NodeSum leftResult = findMaxAverage(root.left, result);
		NodeSum rightResult = findMaxAverage(root.right, result);
		int currentNum = leftResult.nodeNum + rightResult.nodeNum + 1;
		int currentSum = leftResult.nodeSum + rightResult.nodeSum + root.val;
		NodeSum currentResult = new NodeSum(root, currentNum, currentSum);
		getMax(leftResult, result);
		getMax(rightResult, result);
		getMax(currentResult, result);
		return currentResult;

	}

	private NodeSum getMax(NodeSum first, NodeSum second) {
		if (first.nodeNum == 0)
			return second;
		if (second.nodeNum == 0) {
			second.node = first.node;
			second.nodeNum = first.nodeNum;
			second.nodeSum = first.nodeSum;
			return second;
		}

		double firstAvg = first.nodeSum / (double) first.nodeNum;
		double secondAvg = second.nodeSum / (double) second.nodeNum;
		if (firstAvg > secondAvg) {
			second.node = first.node;
			second.nodeNum = first.nodeNum;
			second.nodeSum = first.nodeSum;
		}
		return second;
	}

	static class NodeSum {
		public int nodeNum;
		public int nodeSum;
		public TreeNode node;

		public NodeSum(TreeNode node, int nodeNum, int nodeSum) {
			this.node = node;
			this.nodeNum = nodeNum;
			this.nodeSum = nodeSum;
		}

		public NodeSum(NodeSum nodeSum) {
			this.node = nodeSum.node;
			this.nodeNum = nodeSum.nodeNum;
			this.nodeSum = nodeSum.nodeSum;
		}
	}
}