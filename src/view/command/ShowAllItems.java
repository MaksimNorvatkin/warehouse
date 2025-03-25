package view.command;

import view.ConsoleUI;

public class ShowAllItems extends Command {
    public ShowAllItems(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Показать все товары на складе";
    }

    @Override
    public void execute() {
        consoleUi.showAllItems();
    }
}