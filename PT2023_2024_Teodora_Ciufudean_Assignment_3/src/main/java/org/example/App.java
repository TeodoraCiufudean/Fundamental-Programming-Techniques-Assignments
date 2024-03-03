package org.example;

import presentation.*;

/**
 * Hello world!
 *
 */
/**
 * The main class representing the entry point of the application.
 */
public class App {
    /**
     * The main method that is executed when the application starts.
     *
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Create instances of the views and the controller
        MainView mainView = new MainView();
        ClientView clientView = new ClientView();
        ProductView productView = new ProductView();
        OrderView orderView = new OrderView();
        Controller controller = new Controller(mainView, clientView, productView, orderView);
    }
}

