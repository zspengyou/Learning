package leetcode.binarytree;

import edu.princeton.cs.algs4.In;
import java.util.HashMap;
import java.util.Map;

public class ValidateBinarySearchTree {

    class Solution {
        Map<TreeNode, Integer> leftMax = new HashMap<>();
        Map<TreeNode, Integer> rightMin = new HashMap<>();

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return false;
            }
            int left = root.left == null ? Integer.MIN_VALUE : visitLeft(root.left);
            int right = root.right == null ? Integer.MAX_VALUE : visitRight(root.right);
            if (left >= root.val || root.val >= right) {
                return false;
            } else {
                return true;
            }
        }

        private int visitRight(TreeNode node) {

            if (node.left != null) {
                if (node.left.val >= node.val) {
                    return Integer.MIN_VALUE;
                }
            }
            return 0;
        }

        private int visitLeft(TreeNode node) {
            return 0;
        }

    }
}
