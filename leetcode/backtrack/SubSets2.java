package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {
    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/subsets-ii/");

        int[] nums = new int[]{1, 2, 2};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("new Solution().subsetsWithDup(nums) = " + new Solution().subsetsWithDup(nums));
    }

    static class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> track = new ArrayList<>();
            int startIndex = 0;
            dfs(nums, startIndex, track, ans);
            return ans;
        }

        private void dfs(int[] nums, int startIndex, List<Integer> track, List<List<Integer>> ans) {
            if (startIndex == nums.length) {
                ans.add(track);
                return;
            }
            int runner = startIndex + 1;
            while (runner < nums.length && nums[runner] == nums[startIndex]) {
                runner++;
            }

            for (int i = startIndex; i < runner; i++) {
                int dulCount = i - startIndex;
                List<Integer> newTrack = new ArrayList<>(track);
                while (dulCount >= 0) {
                    newTrack.add(nums[startIndex]);
                    dulCount--;
                }
                dfs(nums, runner, newTrack, ans);
            }
            dfs(nums, runner, track, ans);
        }

    }

    static class Solution2 {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> track = new ArrayList<>();
            int startIndex = 0;
            dfs2(nums, startIndex, track, ans);
            return ans;
        }


        private void dfs2(int[] nums, int startIndex, List<Integer> track, List<List<Integer>> ans) {
            if (startIndex == nums.length) {
                ans.add(track);
                return;
            }

            int runner = startIndex + 1;
            // nums.length or next index that not equal the current value
            while (runner < nums.length && nums[runner] == nums[startIndex]) {
                runner++;
            }
            dfs2(nums, runner, track, ans);//not include current value
            for (int i = startIndex; i < runner; i++) {//handle duplicate
                List<Integer> newTrack = new ArrayList<>(track);
                int totalCount = i - startIndex + 1;// count of duplicate
                for (int j = 0; j < totalCount; j++) {
                    newTrack.add(nums[startIndex]);
                }
                dfs2(nums, runner, newTrack, ans);
            }
        }
    }
}
