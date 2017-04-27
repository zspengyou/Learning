package lintcode;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 2, 4, 9, 5, 6, 8 ,8,10};
		int length = nums.length;
		int[] tmp = new int[length];
		mergeSort(nums, 0, length-1, tmp);
		String result = Arrays.toString(nums);
		System.out.println(result);
	}

	public static void mergeSort(int[] nums, int start, int end, int[] tmp) {
		if (start >= end)
			return;
		int mid = start + (end - start) / 2;
		mergeSort(nums, start, mid, tmp);
		mergeSort(nums, mid + 1, end, tmp);
		merge(nums, start, end, tmp);
	}

	public static void merge(int[] nums, int start, int end, int[] tmp) {
		int mid = start + (end - start) / 2;
		int i = start;
		int j = mid + 1;
		int pos = start;
		while (i <= mid && j <= end) {
			if (nums[i] <= nums[j]) {
				tmp[pos++] = nums[i++];
			} else {
				tmp[pos++] = nums[j++];
			}
		}
		while (i <= mid)
			tmp[pos++] = nums[i++];
		while (j <= end)
			tmp[pos++] = nums[j++];
		for (int k = start; k <= end; k++) {
			nums[k] = tmp[k];
		}
	}

}
