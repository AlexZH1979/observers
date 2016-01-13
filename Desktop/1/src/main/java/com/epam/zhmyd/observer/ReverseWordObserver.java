package com.epam.zhmyd.observer;

/**
 * Prints 'reversed' text
 */
public class ReverseWordObserver implements Observer<String> {

    private StringBuilder result = new StringBuilder();

    @Override
    public void update(String word) {
        StringBuilder builder = new StringBuilder(word);
        result.append(builder.reverse().toString()).append(" ");
    }

    @Override
    public String getResult() {
        return result.toString();
    }
}
