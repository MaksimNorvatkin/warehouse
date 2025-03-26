package view.command;

import view.ConsoleUI;

public class AddItem extends Command {
    public AddItem(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Начать отгрузку товара";
    }
    @Override
    public void execute() {
        consoleUi.addItem();
    }
}
