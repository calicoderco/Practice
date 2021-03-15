package com.cc.practice.sentenceSimilarity;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SentenceSimilarityTest {

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<String>> pairs = new LinkedList<>();
        List<String> pair;
        pair = new ArrayList<>(2);
        pair.add("great");
        pair.add("fine");
        pairs.add(pair);
        pair = new ArrayList<>(2);
        pair.add("drama");
        pair.add("acting");
        pairs.add(pair);
        pair = new ArrayList<>(2);
        pair.add("skills");
        pair.add("talent");
        pairs.add(pair);
        Assert.assertEquals(true, solution.areSentencesSimilar(new String[]{"great", "acting", "skills"}, new String[]{"fine", "drama", "talent"}, pairs));
    }
}
