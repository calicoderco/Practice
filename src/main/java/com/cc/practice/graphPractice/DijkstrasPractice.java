package com.cc.practice.graphPractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DijkstrasPractice {


/*
    private interface Graph<E extends Comparable>  {
        public void addEdge(E from, E to);
        public void removeEdge(E from, E to);
    }

    private static class AdjacencyGraph<E> implements Graph<E> {
        Map<E, Set<E>> adjacencies = new HashMap<>();

        Set<E> membershipSet = new HashSet<E>();

        @Override
        public void addEdge(E from, E to) {
            if(!adjacencies.containsKey(from)) {
                adjacencies.put(from, new HashSet<E>());
            }

            adjacencies.get(from).add(to);
        }

        @Override
        public void removeEdge(E from, E to) {
            adjacencies.get(from).remove(to);
            if (adjacencies.get(from).isEmpty()) {
                adjacencies.remove(from);
            }
        }
    }

    private static class GraphReader {
        public GraphReader(File file) throws IOException {
            FileReader reader = new FileReader(file);
            char[] buf = new char[256];
            while(reader.read(buf, 0, 0) > 0) {

            }
        }
    }

    public static void main(String[] args) {
        DijkstrasPractice.class.getResource("inputFile.graph");


        Graph<Integer> graph = new AdjacencyGraph<>();
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
    }*/
}
