package view.command;

import view.ConsoleUI;

public class ShowMoveItems extends Command{
    public ShowMoveItems(ConsoleUI consoleUi) {
            super(consoleUi);
            menuText = "Переместить товар";
        }

    @Override
    public void execute() {
        consoleUi.moveItemsBetweenWarehouses();
    }
}
