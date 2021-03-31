package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/subsets/");
    }

    // dfs
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
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
            List<Integer> newTrack = new ArrayList<>(track);
            newTrack.add(nums[startIndex]);
            dfs(nums, startIndex + 1, newTrack, ans);
            dfs(nums, startIndex + 1, track, ans);
        }
    }

    // backtrack
    class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> track = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            int startIndex = 0;
            backTrack(track, ans, startIndex, nums);
            return ans;

        }

        private void backTrack(List<Integer> track, List<List<Integer>> ans, int startIndex, int[] nums) {
            if (startIndex == nums.length) {
                ans.add(new ArrayList<>(track));
                return;
            }

            backTrack(track, ans, startIndex + 1, nums);

            track.add(nums[startIndex]);
            backTrack(track, ans, startIndex + 1, nums);
            track.remove(track.size() - 1);
        }
    }
}
