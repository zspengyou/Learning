package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, new ArrayComparator());

            int count = 1;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i - 1][1] >= intervals[i][0]) {
                    continue;
                }
                count++;
            }
            int[][] result = new int[count][2];
            int nextIntervalIndex = 1;
            for (int i = 0; i < count; i++) {
                int[] interval = new int[2];
                interval[0] = intervals[nextIntervalIndex - 1][0];
                interval[1] = intervals[intervals.length - 1][1];
                while (nextIntervalIndex < intervals.length) {
                    if (intervals[nextIntervalIndex - 1][1] >= intervals[nextIntervalIndex][0]) {//overlap
                        nextIntervalIndex++;
                        continue;
                    } else {//not overlap
                        interval[1] = intervals[nextIntervalIndex - 1][1];
                        nextIntervalIndex++;
                        break;
                    }
                }
                result[i] = interval;
            }
            return result;
        }

        class ArrayComparator implements Comparator<int[]> {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

}
