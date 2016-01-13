package com.epam.zhmyd.observer;

/**
 * Calculates quantity worst in the text
 */
public class WordCounterObserver implements Observer<Long> {

    private long count;

    @Override
    public void update(String word) {
        count++;
    }

    @Override
    public Long getResult() {
        return count;
    }
}
