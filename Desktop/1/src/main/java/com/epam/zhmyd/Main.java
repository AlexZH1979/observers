package com.epam.zhmyd;

public class Main {
    public static void main(String[] args) {
        String name = args.length > 0 ? args[0] : null;
        Application app = new Application(name);
        app.apply();
    }
}
