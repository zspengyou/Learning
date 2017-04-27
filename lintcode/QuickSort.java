package lintcode;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
//		int[] nums = new int[] { 1, 3, 4, 2 };
				int[] nums = new int[] { 1, 3, 4, 7, 9, 2, 5 };
		quickSort(nums, 0, nums.length - 1);
		String result = Arrays.toString(nums);
		System.out.println(result);

	}

	public static void quickSort(int[] nums, int start, int end) {
		if (start >= end)
			return;
		int mid = start + (end - start) / 2;
		int val = nums[mid];
		int left = start;
		int right = end;
		while (left <= right) {
			while (left <= right && nums[left] < val) {
				left++;
			}
			while (left <= right && nums[right] > val) {
				right--;
			}
			if (left <= right) {
				int tmp = nums[left];
				nums[left] = nums[right];
				nums[right] = tmp;
				left++;
				right--;
			}
		}
		quickSort(nums, start, right);
		quickSort(nums, left, end);
	}

}
