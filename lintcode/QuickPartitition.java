package lintcode;

import java.util.Arrays;

public class QuickPartitition {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 5 ,1, 3, 4, 7, 9};
		int partitionVal = 4;
		partition(nums, partitionVal);
		String result = Arrays.toString(nums);
		System.out.println(result);
	}

	public static void partition(int[] nums, int val) {
		int length = nums.length;
		int left = 0;
		int right = length - 1;
		while (left < right) {
			while (left < right && nums[left] < val)
				left++;
			while (left < right && nums[right] >= val)
				right--;
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			left++;
			right--;

		}
	}

}
