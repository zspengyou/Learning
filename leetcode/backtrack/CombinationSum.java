package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/combination-sum/");
    }

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            int startIndex = 0;
            combinationSum(candidates, startIndex, path, ans, target);
            return ans;

        }

        private void combinationSum(int[] candidates, int startIndex, List<Integer> path, List<List<Integer>> ans, int target) {
            int sum = sum(path);
            if (sum > target) {
                return;
            } else if (sum == target) {
                ans.add(new ArrayList<>(path));
            }
            for (int i = startIndex; i < candidates.length; i++) {
                path.add(candidates[i]);
                combinationSum(candidates, i, path, ans, target);
                path.remove(path.size() - 1);
            }
        }

        private int sum(List<Integer> path) {
            int sum = 0;
            for (int num : path) {
                sum += num;
            }
            return sum;
        }

    }

    class Solution2 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> track = new ArrayList<>();
            backTrack(candidates, track, ans, target, 0);
            return ans;

        }

        private void backTrack(int[] candidates, List<Integer> track, List<List<Integer>> ans, int target, int startIndex) {
            if (sum(track) > target) {
                return;
            }
            if (sum(track) == target) {
                ans.add(new ArrayList<>(track));// TODO: need to copy the result
                return;
            }

            for (int i = startIndex; i < candidates.length; i++) {
                track.add(candidates[i]);
                backTrack(candidates, track, ans, target, i);
                track.remove(track.size() - 1);
            }

        }

        private int sum(List<Integer> track) {
            int sum = 0;
            for (int num : track) {
                sum += num;
            }
            return sum;
        }
    }
}
