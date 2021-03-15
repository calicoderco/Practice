package com.cc.practice.courseSchedule;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer>  unvisited = new HashSet<>(),
                visiting = new HashSet<>();
        Stack<Integer> toVisit = new Stack<>();

        Boolean[] memo = new Boolean[numCourses];
        //Arrays.fill(memo, null);

        for(int i = 0; i < numCourses; unvisited.add(i++));

        Map<Integer, List<Integer>> prereqsByCourse = new HashMap<>(numCourses);

        for(int[] prereq : prerequisites) {
            prereqsByCourse.putIfAbsent(prereq[0], new LinkedList<>());
            prereqsByCourse.get(prereq[0]).add(prereq[1]);
        }

        while(toVisit.isEmpty() ) {
            if(unvisited.isEmpty()) {
                break;
            }

            Integer nextUnvisited = unvisited.iterator().next();
            toVisit.add(nextUnvisited);

            while(!toVisit.isEmpty()) {
                Integer top = toVisit.peek();

                if(!unvisited.contains(top)) {
                    toVisit.pop();
                    visiting.remove(top);
                    memo[top] = false;
                } else {
                    unvisited.remove(top);
                    visiting.add(top);

                    if(memo[top] != null && !memo[top].booleanValue()) {
                            toVisit.pop();
                            visiting.remove(top);
                    } else if(prereqsByCourse.containsKey(top)) {
                        for(Integer prereq : prereqsByCourse.get(top)) {
                            if(visiting.contains(prereq)) {
                                return false;
                            } else if(memo[prereq] == null) {
                                toVisit.add(prereq);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
