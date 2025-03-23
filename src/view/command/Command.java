package view.command;

import view.ConsoleUI;

public class Command {
    String menuText;
    ConsoleUI consoleUi;

    public Command(ConsoleUI consoleUi) {
        this.consoleUi = consoleUi;
    }

    public String getMenuText() {
        return menuText;
    }

    public void execute() {

    }
}
