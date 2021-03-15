package com.cc.jpractice;

import java.util.Collection;
import java.util.LinkedList;

public class InheritancePractice {

    public static void main(String[] args) {
        Collection<Auto> col = new LinkedList<>();
        col.add(new Auto());
        col.add(new Car());
        col.add(new Truck());

        col.stream().forEach((auto) -> System.out.println(auto));
    }

    static class Auto {
        public String toString() {
            return "Auto";
        }
    }

    static class Car extends Auto {
        public String toString() {
            return "Car";
        }
    }

    static class Truck extends Auto {
        public String toString() {
            return "Truck";
        }
    }
}
