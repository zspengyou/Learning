package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        System.out.println("https://leetcode.com/problems/insert-interval/");
    }

    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> mergedIntervals = new ArrayList<>();
            if(intervals.length == 0){
                mergedIntervals.add(newInterval);
            }
            for (int i = 0; i < intervals.length; i++) {
                //newInterval is less than the first interval
                if (newInterval[1] < intervals[0][0] ||
                            // newInterval is less than the current interval and greater than previous
                            i > 0 && newInterval[0] > intervals[i - 1][1] && newInterval[1] < intervals[i][0]) {
                    mergedIntervals.add(newInterval);
                    mergedIntervals.add(intervals[i]);
                    // new interval is greater than last interval
                } else if (i == intervals.length - 1 && newInterval[0] > intervals[i][1]) {
                    mergedIntervals.add(intervals[i]);
                    mergedIntervals.add(newInterval);
                    // new interval is overlap with current interval
                } else if (newInterval[0] >= intervals[i][0] && newInterval[0] <= intervals[i][1]) {
                    int[] tmp = new int[2];
                    tmp[0] = intervals[i][0];
                    while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
                        i++;
                    }
                    tmp[1] = Math.max(newInterval[1], intervals[i - 1][1]);
                    mergedIntervals.add(tmp);
                    i--;
                } else {
                    mergedIntervals.add(intervals[i]);
                }
            }
            return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
        }
    }
}
