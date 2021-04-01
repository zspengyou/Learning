package leetcode.backtrack;

import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation2 {
    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/permutations-ii/");
        Permutation2 permutation2 = new Permutation2();
        permutation2.test();
    }

    public void test() {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println("result = " + result);
    }


    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> track = new ArrayList<>();
            Set<Integer> usedIndex = new HashSet<>();
            backTrack(nums, usedIndex, track, ans);
            return ans;
        }

        private void backTrack(int[] nums, Set<Integer> usedIndex, List<Integer> track, List<List<Integer>> ans) {
            if (usedIndex.size() == nums.length) {
                ans.add(new ArrayList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (usedIndex.contains(i)) {
                    continue;
                }
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                int runner = i + 1;//runner is nums.length or next index whose value not equal to current value
                while (runner < nums.length && nums[runner] == nums[i]) {
                    runner++;
                }

                for (int k = i; k < runner; k++) {
                    usedIndex.add(k);
                    track.add(nums[i]);
                }
                backTrack(nums, usedIndex, track, ans);
                for (int k = i; k < runner; k++) {
                    usedIndex.remove(k);
                    track.remove(track.size() - 1);
                }

            }
        }
    }

    class Solution2 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<Integer> track = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            Set<Integer> usedIndex = new HashSet<>();
            Arrays.sort(nums);
            backTrack(track, ans, usedIndex, nums);
            return ans;
        }

        private void backTrack(List<Integer> track, List<List<Integer>> ans, Set<Integer> usedIndex, int[] nums) {
            if (usedIndex.size() == nums.length) {
                ans.add(new ArrayList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                int j = i - 1;
                if (usedIndex.contains(i)) {
                    continue;
                }
                if (j >= 0 && nums[i] == nums[j] && !usedIndex.contains(j)) {
                    System.out.println("j = " + j);
                    continue;
                }

                track.add(nums[i]);
                usedIndex.add(i);
                backTrack(track, ans, usedIndex, nums);
                usedIndex.remove(i);
                track.remove(track.size() - 1);
            }
        }
    }

}
