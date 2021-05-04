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
            if (root.left == null && root.right == null) {
                return true;
            }
            if (root.left != null && root.right == null) {
                int left = visitLeft(root.left);
                if (left >= root.val) {
                    return false;
                } else {
                    return true;
                }
            }
            if (root.left == null && root.right != null) {
                int right = visitRight(root.right);
                if (root.val >= right) {
                    return false;
                } else {
                    return true;
                }
            }
            int left = visitLeft(root.left);
            int right = visitRight(root.right);
            if (left >= root.val || root.val >= right) {
                return false;
            } else {
                return true;
            }

        }

        // max from left
        // if not valid, return Integer.MAX
        private int visitLeft(TreeNode node) {
            if (node.left == null && node.right == null) {
                return node.val;
            }
            if (node.left != null && node.right == null) {
                int left = visitLeft(node.left);
                if (left >= node.val) {
                    return Integer.MAX_VALUE;
                } else {
                    return node.val;
                }
            }
            if (node.left == null && node.right != null) {
                int right = visitRight(node.right);
                if (node.val >= right) {
                    return Integer.MAX_VALUE;
                } else {
                    return right;
                }
            }
            int left = visitLeft(node.left);
            int right = visitLeft(node.right);
            if (left >= node.val || node.val >= right) {
                return Integer.MAX_VALUE;
            } else {
                return right;
            }
        }

        // min from right
        // if not valid, return Integer.MIN
        private int visitRight(TreeNode node) {
            if (node.left == null && node.right == null) {
                return node.val;
            }
            if (node.left != null && node.right == null) {
                int left = visitRight(node.left);
                if (left >= node.val) {
                    return Integer.MIN_VALUE;
                } else {
                    return left;
                }
            }
            if (node.left == null && node.right != null) {
                int right = visitRight(node.right);
                if (node.val >= right) {
                    return Integer.MIN_VALUE;
                } else {
                    return node.val;
                }
            }
            int left = visitRight(node.left);
            int right = visitRight(node.right);
            if (left >= node.val || node.val >= right) {
                return Integer.MIN_VALUE;
            } else {
                return left;
            }

        }


    }
}
