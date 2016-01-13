package com.epam.zhmyd.observer;

import java.util.ArrayList;
import java.util.List;

public class FileReaderObservable implements Observable {

    private List<Observer> observers;
    private String word;

    public FileReaderObservable() {
        observers = new ArrayList<>();
    }

    public void setWord(String word) {
        this.word = word;
        this.notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(word);
        }
    }
}
