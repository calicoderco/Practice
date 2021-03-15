package com.cc.practice.lru;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class LRUCacheTest {

    @Test
    public void test() {

        String[] ops = new String[]{"LRUCache","get","put","get","put","put","get","get"};

        ObjectMapper mapper = new ObjectMapper();

        int[][] ints = null;
        Integer[] expected = null;

        try {
            ints = mapper.readValue("[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]", int[][].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            expected = mapper.readValue("[-1,-1,null,-1,null,null,2,6]", Integer[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LRUCache cache = null;
        int i = 0;
        for(String op : ops) {
            int[] numbers = ints[i];
            switch(op) {
                case "LRUCache":
                    cache = new LRUCache(numbers[0]); break;
                case "put":
                    cache.put(numbers[0], numbers[1]); break;
                case "get":
                    Assert.assertEquals(expected[i].intValue(), cache.get(numbers[0]));
            }

            i++;
        }
    }
}
