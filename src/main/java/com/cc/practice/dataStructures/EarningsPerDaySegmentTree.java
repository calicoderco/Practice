package com.cc.practice.dataStructures;

import java.util.Collections;
import java.util.Date;

public class EarningsPerDaySegmentTree extends SegmentTree<Date, Double, Double> {

    public EarningsPerDaySegmentTree() {
        super(Collections.emptyList());
    }

    @Override
    protected Double computeStatistic(Object left, Object right) {
        return null;
    }

    @Override
    protected Date indexToInterval(int index) {
        return null;
    }
}
