package com.epam.zhmyd;

import static com.epam.zhmyd.Activator.WORD_COUNTER_OBSERVER;
import static com.epam.zhmyd.Activator.LONGEST_WORD_OBSERVER;
import  static com.epam.zhmyd.Activator.NUMBER_COUNTER_OBSERVER;
import static com.epam.zhmyd.Activator.REVERSE_WORD_OBSERVER;

public class Dispatcher {
    private final Activator activator;

    public Dispatcher(Activator activator) {
        this.activator = activator;
    }

    public void dispatch() {
        setActivatorState(true);
        activator.start();
        printResult();
        setActivatorState(false);
    }

    private void setActivatorState(boolean state){
        boolean activate = state&&!activator.isActive();
        if(activate){
            activator.activate();
        } else if(!activate){
            activator.deactivate();
        }
    }

    public void printResult(){
        System.out.println("WORD_COUNTER_OBSERVER: "+WORD_COUNTER_OBSERVER.getCount());
        System.out.println("LONGEST_WORD_OBSERVER: "+LONGEST_WORD_OBSERVER.getWord());
        System.out.println("NUMBER_COUNTER_OBSERVER: "+NUMBER_COUNTER_OBSERVER.getCount());
        System.out.println("REVERSE_WORD_OBSERVER\n"+REVERSE_WORD_OBSERVER.getResult());
    }
}
