package leetcode.backtrack;

import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum2 {
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
            if (startIndex >= candidates.length) {
                return;
            }
            int trackSum = sum(track);
            if (trackSum > target) {
                return;
            } else if (trackSum == target) {
                ans.add(new ArrayList<>(track));
                return;
            }

            // current value equals to previous one and
            // previous value is not used
            if (startIndex > 0 && candidates[startIndex - 1] == candidates[startIndex] && track.size()>0 && track.get(track.size() - 1) != candidates[startIndex]) {
                return;
            } else {
                backtrack(candidates, target, startIndex + 1, track, ans);
                track.add(candidates[startIndex]);
                backtrack(candidates, target, startIndex + 1, track, ans);
                track.remove(track.size() - 1);
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
            Set<Integer> usedIndex = new HashSet<>();
            backtrack(candidates, target, usedIndex, track, ans);
            return ans;

        }

        private void backtrack(int[] candidates, int target, Set<Integer> usedIndex, List<Integer> track, List<List<Integer>> ans) {
            int trackSum = sum(track);
            if (trackSum > target) {
                return;
            } else if (trackSum == target) {
                ans.add(new ArrayList<>(track));
                return;
            }

            for (int i = 0; i < candidates.length; i++) {
                if (usedIndex.contains(i)) {
                    continue;
                }
                if (i > 0 && candidates[i - 1] == candidates[i] && !usedIndex.contains(i - 1)) {
                    continue;
                }
                usedIndex.add(i);
                track.add(candidates[i]);
                backtrack(candidates, target, usedIndex, track, ans);
                track.remove(track.size() - 1);
                usedIndex.remove(i);
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
