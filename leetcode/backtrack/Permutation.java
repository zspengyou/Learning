package leetcode.backtrack;

import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/permutations/");
    }
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> track = new ArrayList<>();
            HashSet<Integer> usedIndex = new HashSet<>();

            brackTrack(nums, usedIndex, track, ans);
            return ans;
        }

        private void brackTrack(int[] nums, HashSet<Integer> usedIndex, List<Integer> track, List<List<Integer>> ans) {
            if (usedIndex.size() == nums.length) {
                ans.add(new ArrayList<>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (usedIndex.contains(i)) {
                    continue;
                }
                track.add(nums[i]);
                usedIndex.add(i);
                brackTrack(nums, usedIndex, track, ans);
                usedIndex.remove(i);
                track.remove(track.size() - 1);
            }
        }
    }




}
