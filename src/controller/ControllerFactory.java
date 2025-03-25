package controller;

import view.ConsoleUI;

public class ControllerFactory {
    public static ItemController createController() {
        // Сначала создаем контроллер с временным null для View
        ItemControllerImpl controller = new ItemControllerImpl(null);

        // Затем создаем ConsoleUI, передавая контроллер
        ConsoleUI consoleUI = new ConsoleUI(controller);

        // Устанавливаем View в контроллер
        controller.setView(consoleUI);

        return controller;
    }
}