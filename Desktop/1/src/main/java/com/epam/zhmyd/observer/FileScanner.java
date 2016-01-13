package com.epam.zhmyd.observer;

import java.io.*;

public class FileScanner {

    private final String fileName;
    private final FileReaderObservable observable;

    public FileScanner(String fileName, FileReaderObservable obs) {
        this.fileName = fileName;
        this.observable = obs;
    }

    public void read() throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line;
        while ((line = br.readLine()) != null) {
            // \\s+ means any number of whitespaces between tokens
            String[] tokens = line.split("\\s+");
            this.processLine(tokens);
        }
    }

    private void processLine(String[] str) {
        for (String word : str) {
            observable.setWord(word);
        }
    }

}
