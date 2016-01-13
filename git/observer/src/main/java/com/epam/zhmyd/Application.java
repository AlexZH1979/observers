package com.epam.zhmyd;

public class Application {

    public static void main(String[] args) {
        String name = args.length>0?args[0]:"";
        Activator activator =new Activator(name);
        Dispatcher dispatcher = new Dispatcher(activator);
        dispatcher.dispatch();
    }
}
