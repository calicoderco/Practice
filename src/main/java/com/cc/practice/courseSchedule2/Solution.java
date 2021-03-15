package com.cc.practice.courseSchedule2;

import java.util.*;

class Solution {
    Map<Integer, List<Integer>> dependentsByCourse;
    Set<Integer> addedToResult = new HashSet<Integer>(),
        visiting = new HashSet<Integer>();
    LinkedList<Integer> result = new LinkedList<>();
    Set<Integer> unvisited = new HashSet<>();

    Stack<Integer> resultStack = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        dependentsByCourse = new HashMap<>();

        for(int[] prereq : prerequisites) {
            dependentsByCourse.putIfAbsent(prereq[1], new LinkedList<>());
            dependentsByCourse.get(prereq[1]).add(prereq[0]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) {
                return new int[0];
            }
        }

        int[] r = new int[resultStack.size()];
        for(int i = 0; resultStack.size() > 0;  r[i++] = resultStack.pop());
        return r;
    }

    private boolean dfs(int top) {
        if(!addedToResult.contains(top)) {
            visiting.add(top);
            if (dependentsByCourse.containsKey(top)) {
                for (int dependent : dependentsByCourse.get(top)) {
                    if(visiting.contains(dependent) || !dfs(dependent)) {
                        return false;
                    }
                }
            }
            visiting.remove(top);
            addedToResult.add(top);
            resultStack.push(top);
        }

        return true;
    }

    /*private boolean dfs(int top) {
        if(!addedToResult.contains(top)) {
            if(visiting.contains(top)) {
                return false;
            }

            visiting.add(top);
            if (prereqsByCourse.containsKey(top)) {
                for (int prereq : prereqsByCourse.get(top)) {
                    if(!dfs(prereq)) {
                        return false;
                    }
                }
            }
            visiting.remove(top);
            addedToResult.add(top);
            unvisited.remove(top);
            result.add(top);
        }

        return true;
    }*/

    /*public int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> traversalStack = new Stack<>();
        Set<Integer> unvisited = new HashSet<>();
        Set<Integer> toVisit = new HashSet<>();
        LinkedList<Integer> result = new LinkedList<>();
        Set<Integer> addedToResult = new HashSet<Integer>();
        Set<Integer> processedNeighbors = new HashSet<Integer>();

        for(int i = 0; i < numCourses; unvisited.add(i++));

        Map<Integer, List<Integer>> prereqsByCourse = new HashMap<>(numCourses);

        for(int[] prereq : prerequisites) {
            prereqsByCourse.putIfAbsent(prereq[0], new LinkedList<>());
            prereqsByCourse.get(prereq[0]).add(prereq[1]);
        }

        while(unvisited.size() > 0) {
            Integer nextUnvisited = unvisited.iterator().next();
            traversalStack.push(nextUnvisited);
            toVisit.add(nextUnvisited);

            while(!traversalStack.isEmpty()) {
                int top = traversalStack.peek();
                if(processedNeighbors.contains(top)) {
                    if(!addedToResult.contains(top)) {
                        addedToResult.add(top);
                        result.add(top);
                        unvisited.remove(top);
                    }

                    toVisit.remove(top);
                    traversalStack.pop();
                } else {
                    if (prereqsByCourse.containsKey(top)) {
                        for (int prereq : prereqsByCourse.get(top)) {
                            if (toVisit.contains(prereq) && processedNeighbors.contains(prereq)) {
                                return new int[0];
                            }
                            if (!addedToResult.contains(prereq)) {
                                traversalStack.push(prereq);
                                toVisit.add(prereq);
                            }
                        }
                    }
                    processedNeighbors.add(top);
                }
            }
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }*/
}
