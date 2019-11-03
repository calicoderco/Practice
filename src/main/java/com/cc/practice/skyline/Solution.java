package com.cc.practice.skyline;

import java.util.*;

class Solution {

    Comparator<int[]> comparatorByHeight = new Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
            return height(b) - height(a);
        }
    };

    PriorityQueue<int[]> visitedByHeight = new PriorityQueue<>(comparatorByHeight);

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> results = new ArrayList<>();

        int currentLeftIndex = Integer.MIN_VALUE;
        int[] current = null;

        List<Integer> nextResult = null;

        for(int[] building : buildings) {
            if(current != null) {
                if(left(building) == left(current)) {
                    if(height(building) > height(current)) {
                        //current is now the building we are currently looking at because it is higher and at the same starting point as previous current
                        //thus, it overshadows the previous current building
                        current = building;
                        nextResult = new ArrayList<>();
                        nextResult.add(left(current));
                        nextResult.add(height(current));
                    }
                } else {//left(building) > left(current) is always true in this case b/c of the ordering of the input buildings

                    if(height(building) >= height(current)) {
                        if(height(building) != height(current)) {
                            results.add(nextResult);
                            current = building;
                            nextResult = new ArrayList<>(2);
                            nextResult.add(left(current));
                            nextResult.add(height(current));
                        } else if(right(building) > right(current) && left(building) <= right(current)) {
                                current = building;
                        }
                    }
                }

                if(left(building) > right(current)) {
                    int[] highestVisitedBuilding = null;
                    while(visitedByHeight.size() > 0) {
                        highestVisitedBuilding = visitedByHeight.poll(); //remove the highest building i've visited so far
                        if(right(highestVisitedBuilding) > right(current)) {
                            if(height(highestVisitedBuilding) == height(current)) {
                                current = highestVisitedBuilding;
                            } else {
                                results.add(nextResult);

                                //this is the point we will drop down to, from above
                                nextResult = new ArrayList<>(2);
                                nextResult.add(right(current));
                                nextResult.add(height(highestVisitedBuilding));
                                break;
                            }
                        } // otherwise just let it be removed and move on
                    }

                    if(highestVisitedBuilding == null) {
                        nextResult = new ArrayList<>(2);
                        nextResult.add(right(current));
                        nextResult.add(0);
                        results.add(nextResult);
                        nextResult = null;
                        current = building;
                    }

                    if(highestVisitedBuilding == current) {
                        results.add(nextResult);
                        nextResult = new ArrayList<>(2);
                        nextResult.add(right(current));
                        nextResult.add(0);
                        results.add(nextResult);
                        nextResult = new ArrayList<>(2);
                        nextResult.add(left(building));
                        nextResult.add(height(building));
                        current = building;

                    }
                }
            } else {
                current = building;
                nextResult = new ArrayList<>();
                nextResult.add(left(current));
                nextResult.add(height(current));
            }

            visitedByHeight.add(building);
        }



        int[] highestVisitedBuilding = null;
        while(visitedByHeight.size() > 0) {
            highestVisitedBuilding = visitedByHeight.poll(); //remove the highest building i've visited so far
            if(right(highestVisitedBuilding) > right(current)) {
                if(height(highestVisitedBuilding) == height(current)) {
                    current = highestVisitedBuilding;
                } else {
                    results.add(nextResult);

                    //this is the point we will drop down to, from above
                    nextResult = new ArrayList<>(2);
                    nextResult.add(right(current));
                    nextResult.add(height(highestVisitedBuilding));
                    current = highestVisitedBuilding;
                }
            } // otherwise just let it be removed and move on
        }

        results.add(nextResult);
        nextResult = new ArrayList<>(2);
        nextResult.add(right(current));
        nextResult.add(0);
        results.add(nextResult);

        return results;
    }

    private static int height(int[] building) {
        return building[2];
    }

    private static int left(int[] building) {
        return building[0];
    }

    private static int right(int[] building) {
        return building[1];
    }
}
