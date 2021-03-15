package com.cc.practice.nQueens;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new LinkedList<>();
        Set<Integer> uncovered = new HashSet<>();
        Set<Integer> queenIndexes = new HashSet<Integer>();
        Set<Integer> availableQueenIndexes = new HashSet<>();
        for(int i = 0; i < n * n; i++) {
            availableQueenIndexes.add(i);
            uncovered.add(i);
        }
        
        solveNQueens(uncovered, availableQueenIndexes, results, queenIndexes, n);
        
        return results;
    }

    public void solveNQueens(Set<Integer> uncovered, Set<Integer> availableQueenIndexes, List<List<String>> results, Set<Integer> queenIndexes, int n) {
        if(uncovered.isEmpty() && queenIndexes.size() == n) {
            List<String> sResult = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder rowBuilder = new StringBuilder();
                for(int j = 0; j < n; j++) {
                   rowBuilder.append(queenIndexes.contains(i * n + j) ? 'Q' : '.');
                }
                sResult.add(rowBuilder.toString());
            }
            results.add(sResult);
        } else {
            Set<Integer> removedAvailableQueenIndexesForStack = new HashSet<>();
            while(!availableQueenIndexes.isEmpty()) {
                //create a new queen at an available index
                int nextQueenIndex = availableQueenIndexes.iterator().next();
                queenIndexes.add(nextQueenIndex);

                //mark all indexes covered by the new queen
                Set<Integer> covered = markCoveredBy(uncovered, nextQueenIndex, n);
                uncovered.removeAll(covered);
                Set<Integer> removedAvailableQueenIndexes = availableQueenIndexes.stream().filter( x -> covered.contains(x)).collect(Collectors.toSet());
                availableQueenIndexes.removeAll(removedAvailableQueenIndexes);

                //generate all solutions that include all queens previously selected and the new queen
                solveNQueens(uncovered, availableQueenIndexes, results, queenIndexes, n);

                //remove this queen index and remark all indexes covered by it as uncovered now
                //do not add this queen index back to the available indexes, to prevent duplicate solutions
                queenIndexes.remove(nextQueenIndex);
                uncovered.addAll(covered);
                availableQueenIndexes.addAll(removedAvailableQueenIndexes);
                availableQueenIndexes.remove(nextQueenIndex);
                removedAvailableQueenIndexesForStack.add(nextQueenIndex);
            }
            availableQueenIndexes.addAll(removedAvailableQueenIndexesForStack);
        }
    }

    private Set<Integer> markCoveredBy(Set<Integer> uncovered,  int queenIndex, int n) {
        Set<Integer> covered = new HashSet<>();

        for(int coveredIndex = (queenIndex / n) * n; coveredIndex < ((queenIndex / n) * n) + n; coveredIndex++) {
            //uncovered.remove(coveredIndex);
            covered.add(coveredIndex);
        }

        for(int coveredRow = 0; coveredRow < n; coveredRow++) {
            //uncovered.remove(coveredRow + (queenIndex % n));
            covered.add((coveredRow * n) + (queenIndex % n));
        }

        for(int row = (queenIndex / n) - 1, distance = 1; row >= 0; row--, distance++) {
            if((queenIndex % n) + distance < n) {
                //uncovered.remove(row + (queenIndex % n) + distance);
                covered.add((row * n) + (queenIndex % n) + distance);
            }
            
            if((queenIndex % n) - distance >= 0) {
                //uncovered.remove(row + (queenIndex % n) - distance);
                covered.add((row * n) + (queenIndex % n) - distance);
            }
        }

        for(int row = (queenIndex / n) + 1, distance = 1; row < n; row++, distance++) {
            if((queenIndex % n) + distance < n) {
                //uncovered.remove(row + (queenIndex % n) + distance);
                covered.add((row * n) + (queenIndex % n) + distance);
            }

            if((queenIndex % n) - distance >= 0) {
                //uncovered.remove(row + (queenIndex % n) - distance);
                covered.add((row * n)+ (queenIndex % n) - distance);
            }
        }

        covered.retainAll(uncovered);

        return covered;
    }
}
