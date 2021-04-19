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

            for (int i = 0; i < intervals.length; i++) {
                if (i == 0 && newInterval[1] < intervals[i][0] ||
                            newInterval[0]> intervals[i-1][1] &&newInterval[1] < intervals[i][0] ) {
                    mergedIntervals.add(newInterval);
                    mergedIntervals.add(intervals[i]);
                } else if (i == intervals.length - 1 && newInterval[0] > intervals[i][1] ) {
                    mergedIntervals.add(intervals[i]);
                    mergedIntervals.add(newInterval);
                }else if(newInterval[0]>= intervals[i][0] && newInterval[0] <= intervals[i][1]){
                    int[] tmp = new int[2];
                    tmp[0] = intervals[i][0];
                    tmp[0] = newInterval[1];
                    while (i < intervals.length && newInterval[1]>= intervals[i][1]){
                        i++;
                    }
                    if(i== intervals.length){
                        tmp[1] = newInterval[1];
                    }
                }
            }
            return null;
        }


    }
}
