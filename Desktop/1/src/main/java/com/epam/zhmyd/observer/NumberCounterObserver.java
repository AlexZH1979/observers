package com.epam.zhmyd.observer;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * Calculates quantity 'numbers' in the text
 */
public class NumberCounterObserver implements Observer<Long> {


    private long numberCount = 0;

    @Override
    public void update(String word) {
        if (NumberUtils.isNumber(word)) {
            numberCount++;
        }
    }

    @Override
    public Long getResult() {
        return numberCount;
    }
}
