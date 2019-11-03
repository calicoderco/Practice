package com.cc.practice.insertInterval;

import java.util.LinkedList;
import java.util.List;

class Solution {
    /*public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new LinkedList<>();
        int[] toInsert = new int[2];
        toInsert[0] = newInterval[0];
        toInsert[1] = newInterval[1];
        int[] beforeMerge = null;
        int i, skipped = 0;
        for(i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if((toInsert[1] < interval[0] && (i == skipped || (beforeMerge != null && toInsert[0] > beforeMerge[1]) || toInsert[0] > intervals[i - 1][1]))) {
                resultList.add(toInsert);
                resultList.add(interval);
                i++;
                break;
            } else if (toInsert[0] > interval[1] && (resultList.size() == intervals.length - skipped || toInsert[1] < intervals[i + 1][0])) {
                resultList.add(interval);
                resultList.add(toInsert);
                i++;
                break;
            } else if(intervalIsContained(interval, toInsert)) {
                //interval is completely contained, so skip
                skipped++;
            } else if(isMergeable(interval, toInsert)) {
                if(beforeMerge == null && i > 0) {
                    beforeMerge = intervals[i - 1];
                }
                toInsert[0] = Math.min(interval[0], toInsert[0]);
                toInsert[1] = Math.max(interval[1], toInsert[1]);
                skipped++;
            } else if(toInsertIsInsideInterval(interval, toInsert)) {
                //toInsert is inside, so dont ever add it
                resultList.add(interval);
                i++;
                break;
            } else {
                resultList.add(interval);
            }
        }

        for(; i < intervals.length; i++) {
            resultList.add(intervals[i]);
        }

        int[][] results = new int[resultList.size()][];
        int j = 0;
        for(int[] interval : resultList) {
            results[j] = interval;
            j++;
        }

        return results;
    }

    private boolean isMergeable(int[] interval, int[] toInsert) {
        return (interval[0] > toInsert[0] && interval[0] <= toInsert[1] && interval[1] >= toInsert[1]) || //overlaps on the left of interval
                (interval[1] < toInsert[1] && interval[0] <= toInsert[0] && interval[1] >= toInsert[0]); //overlaps on the right of interval
    }

    private boolean toInsertIsInsideInterval(int[] interval, int[] toInsert) {
        return interval[1] >= toInsert[1] && interval[0] <= toInsert[0];
    }

    private boolean intervalIsContained(int[] interval, int[] toInsert) {
        return interval[0] >= toInsert[1] && interval[1] <= toInsert[1];
    }*/

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int leftSlot = findSlot(intervals, newInterval[0]),
                rightSlot = findSlot(intervals, newInterval[1]);


        return null;
    }

    private int findSlot(int[][] intervals, int target) {
        int slots = intervals.length * 2 + 1;
        int left = 0, right = slots - 1;
        int slot = -1;

        while(slot == -1) {
            int mid = left + (right - left) / 2;
            if(mid % 2 == 1) {
                int intervalIndex = (mid - 1) / 2;
                if(target > intervals[intervalIndex][1] ) {
                    left = right - left == 1 ? mid + 1 : mid;
                } else if(target < intervals[intervalIndex][0]) {
                    right = mid;
                } else {
                    slot = mid;
                    break;
                }
            } else {
                int leftIntervalIndex = (mid - 1) / 2;
                int rightIntervalIndex = leftIntervalIndex + 1;
                if(rightIntervalIndex > intervals.length - 1 || target > intervals[rightIntervalIndex][0]) {
                    if(rightIntervalIndex > intervals.length - 1) {
                        slot = rightIntervalIndex;
                    } else {
                        left = right - left == 1 ? mid + 1 : mid;
                    }
                } else if(leftIntervalIndex <= 0 || target < intervals[leftIntervalIndex][1]) {
                    if(leftIntervalIndex <= 0) {
                        slot = leftIntervalIndex;
                        break;
                    } else {
                        right = mid;
                    }
                } else {
                    slot = mid;
                    break;
                }
            }
        }

        return slot;
    }
}
