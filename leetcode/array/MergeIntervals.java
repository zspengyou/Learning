package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(2);
        tmp.add(3);
        Integer[]tmpresult = tmp.toArray(new Integer[3]);
        System.out.println("result = " + Arrays.toString(tmpresult));
    }
    class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, new ArrayComparator());

            List<int[]> mergedIntervals = new ArrayList<>();

            int index = 0;
            while (index < intervals.length) {
                int[] currentInterval = new int[2];
                currentInterval[0] = intervals[index][0];
                currentInterval[1] = intervals[index][1];
                index++;
                while (index < intervals.length && currentInterval[1] >= intervals[index][0]) {
                    currentInterval[1] = Integer.max(currentInterval[1], intervals[index][1]);
                    index++;
                }
                mergedIntervals.add(currentInterval);
            }

            return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
        }

        class ArrayComparator implements Comparator<int[]> {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        }
    }

}
