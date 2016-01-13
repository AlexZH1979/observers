package com.epam.zhmyd.observer;

/**
 * Calculates size of longest word in text
 */
public class LongestWordObserver implements Observer<String> {

    private String longestWord;

    @Override
    public void update(String word) {
        if ((longestWord == null) || (longestWord.length() < word.length())) {
            longestWord = word;
        }
    }

    @Override
    public String getResult() {
        return longestWord;
    }
}
