package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/insert-interval/");
        InsertInterval insertInterval = new InsertInterval();
        insertInterval.test();
    }

    private void test() {
        int[][] intervals = new int[2][];
        intervals[0] = new int[]{1,3};
        intervals[1] = new int[]{6,9};
        int[] newInterval = new int[]{2,5};
        Solution solution = new Solution();
        int[][] result = solution.insert(intervals,newInterval);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }

    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> mergedIntervals = new ArrayList<>();

            int index = 0;
            // current interval end < new interval start
            while (index < intervals.length && intervals[index][1] < newInterval[0]) {
                mergedIntervals.add(intervals[index]);
                index++;
            }
            // current interval end >= new interval start
            int tmpStart = newInterval[0];
            int tmpEnd = newInterval[1];
            while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
                tmpStart = Math.min(intervals[index][0], tmpStart);
                tmpEnd = Math.max(intervals[index][1], tmpEnd);
                index++;
            }
            mergedIntervals.add(new int[]{tmpStart, tmpEnd});

            // current interval start > new interval end
            while (index < intervals.length && intervals[index][0] > newInterval[1]) {
                mergedIntervals.add(intervals[index]);
                index++;
            }
            return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
        }
    }
}
