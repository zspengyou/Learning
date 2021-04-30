package leetcode.array;

public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int current = nums1.length - 1;
            int left = m - 1;
            int right = n - 1;
            while (left >= 0 && right >= 0) {
                if (nums1[left] <= nums2[right]) {
                    nums1[current] = nums2[right];
                    right--;
                } else {
                    nums1[current] = nums1[left];
                    left--;
                }
                current--;
            }
            while (right >= 0) {
                nums1[current] = nums2[right];
                right--;
                current--;
            }
        }
    }
}
