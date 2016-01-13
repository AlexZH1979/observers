package com.epam.zhmyd;

import com.epam.zhmyd.observer.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Activator {

    private File file;
    private String fileName = "";
    public static final WordCounterObserver WORD_COUNTER_OBSERVER = new WordCounterObserver();
    public static final NumberCounterObserver NUMBER_COUNTER_OBSERVER = new NumberCounterObserver();
    public static final LongestWordObserver LONGEST_WORD_OBSERVER = new LongestWordObserver();
    public static final ReverseWordObserver REVERSE_WORD_OBSERVER = new ReverseWordObserver();

    private FileReader fileReader;

    private boolean active;

    private static final String ENTER_FILE_NAME = "Please enter file name:";

    public Activator(String name) {
        this.fileName = name;
    }

    public void activate() {
        fileName = !fileName.isEmpty() ? fileName : getFileName();

        file = getFile();

        fileReader = new FileReader(file);
        fileReader.addObserver(WORD_COUNTER_OBSERVER);
        fileReader.addObserver(NUMBER_COUNTER_OBSERVER);
        fileReader.addObserver(LONGEST_WORD_OBSERVER);
        fileReader.addObserver(REVERSE_WORD_OBSERVER);

        active = true;
    }

    public void deactivate() {
        fileReader = null;
        file = null;
        active = false;
    }

    public void start() {
        try {
            fileReader.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isActive() {
        return active;
    }

    private String getFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_FILE_NAME);
        String fileName = scanner.nextLine();
        System.out.println(fileName);
        return fileName;
    }

    private File getFile() {
        File file = new File(fileName);
        if (file == null || !file.isFile()) {
            fileName = getFileName();
            file = getFile();
        }
        return file;
    }
}
