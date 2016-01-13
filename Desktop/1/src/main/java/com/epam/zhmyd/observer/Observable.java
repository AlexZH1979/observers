package com.epam.zhmyd.observer;

public interface Observable {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}