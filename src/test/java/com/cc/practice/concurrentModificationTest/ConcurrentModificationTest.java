package com.cc.practice.concurrentModificationTest;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationTest {
    @Test
    public void testRemove1() {
        List<String> list = new ArrayList<>();
        list.add("a");

        for(String s : list) {
            list.remove(s);
        }
    }

    @Test
    public void testRemove2() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        for(String s : list) {
            list.remove(s);
        }
    }

    @Test
    public void testRemove3() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for(String s : list) {
            list.remove(s);
        }
    }

    @Test
    public void testRemove4() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        for(int i = 0; i < list.size(); i++) {
            list.remove(i);
            list.add("z");
        }
    }

    @Test
    public void testRemove5() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");


        for(Iterator<String> it = list.iterator(); it.hasNext();) {
            String next = it.next();
            list.add("z");
        }
    }

    @Test
    public void testRemove6() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        Iterator<String> it = list.iterator();
        it.next();
        list.add("g");
        it.next();
    }

    @Test
    public void testRemove7() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        Iterator<String> it = list.iterator();
        it.hasNext();
        list.add("g");
        it.next();
    }

    @Test
    public void testRemove8() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        Iterator<String> it = list.iterator();
        it.hasNext();
        list.remove("f");
        it.next();
    }

    @Test
    public void testAdd() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        for(String s : list) {
            list.add(s);
        }
    }
}
