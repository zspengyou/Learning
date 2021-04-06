package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println("combinationSum2 = " + combinationSum2);
        combinationSum2.test();

    }

    public void test() {
        Solution solution = new Solution();
        int[] candidates = new int[]{14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12};
        int target = 27;
        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        System.out.println("result = " + result);
    }

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> track = new ArrayList<>();
            int startIndex = 0;
            backtrack(candidates, target, startIndex, track, ans);
            return ans;

        }

        private void backtrack(int[] candidates, int target, int startIndex, List<Integer> track, List<List<Integer>> ans) {
            int trackSum = sum(track);
            if (trackSum > target) {
                return;
            }
            if (startIndex == candidates.length) {
                if (trackSum == target) {
                    ans.add(new ArrayList<>(track));
                }
                return;
            }

            int runner = startIndex + 1;
            while (runner < candidates.length && candidates[startIndex] == candidates[runner]) {
                runner++;
            }

            backtrack(candidates, target, runner, track, ans);
            for (int i = startIndex; i < runner; i++) {// start from current, end with last same value
                int count = i - startIndex + 1;
                for (int j = 0; j < count; j++) {
                    track.add(candidates[startIndex]);
                }
                backtrack(candidates, target, runner, track, ans);
                for (int j = 0; j < count; j++) {
                    track.remove(track.size() - 1);
                }
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
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> track = new ArrayList<>();
            int startIndex = 0;
            backtrack(candidates, target, startIndex, track, ans);
            return ans;

        }

        private void backtrack(int[] candidates, int target, int startIndex, List<Integer> track, List<List<Integer>> ans) {

            int trackSum = sum(track);
            if (trackSum > target) {
                return;
            }
            if (startIndex == candidates.length) {
                if (trackSum == target) {
                    ans.add(track);
                }
                return;
            }

            int runner = startIndex + 1;
            while (runner < candidates.length && candidates[startIndex] == candidates[runner]) {
                runner++;
            }

            backtrack(candidates, target, runner, track, ans);
            for (int i = startIndex; i < runner; i++) {// start from current, end with last same value
                int count = i - startIndex + 1;
                List<Integer> newTrack = new ArrayList<>(track);
                for (int j = 0; j < count; j++) {
                    newTrack.add(candidates[startIndex]);
                }
                backtrack(candidates, target, runner, newTrack, ans);
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

}
