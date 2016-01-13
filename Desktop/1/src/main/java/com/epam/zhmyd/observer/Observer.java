package com.epam.zhmyd.observer;

public interface Observer<T> {
    /**
     * Update observer
     */
    void update(String word);

    /**
     * Return Results of test analysis
     */
    T getResult();
}
