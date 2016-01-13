package com.epam.zhmyd;

import com.epam.zhmyd.observer.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final String ENTER_FILE_NAME = "Please enter file name:";

    private String fileName;

    private final List<ObserverWrapper> observers = Collections.unmodifiableList(
            new ArrayList<ObserverWrapper>() {{
                add(new ObserverWrapper(new ReverseWordObserver(), "Reversed Words: "));
                add(new ObserverWrapper(new WordCounterObserver(), "Words  in Text: "));
                add(new ObserverWrapper(new LongestWordObserver(), "Longest Word: "));
                add(new ObserverWrapper(new NumberCounterObserver(), "Numbers in text: "));
            }});



    public Application(String fileName) {
        this.fileName = fileName;
    }

    public void apply() {
        if (fileName == null) {
            fileName = getFileName();
        }
        FileReaderObservable fileObserver = new FileReaderObservable();
        FileScanner fs = new FileScanner(fileName, fileObserver);
        for (ObserverWrapper ow : observers) {
            fileObserver.registerObserver(ow.getObserver());
        }
        try {
            fs.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        printResult();
    }

    public void printResult() {
        for (ObserverWrapper ow : observers) {
            System.out.println("----------------------------------------");
            System.out.println(ow.printResults());

        }
    }

    private String getFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_FILE_NAME);
        String fileName = scanner.nextLine();
        System.out.println(fileName);
        return fileName;
    }


    static class ObserverWrapper {
        private final String info;
        private final Observer observer;

        public ObserverWrapper(Observer o, String info) {
            this.observer = o;
            this.info = info;
        }

        public Observer getObserver() {
            return observer;
        }

        public String getInfo() {
            return info;
        }

        public String printResults() {
            return info + '\n' + observer.getResult();

        }
    }

}
