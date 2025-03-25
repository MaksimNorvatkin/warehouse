package view.command;

import view.ConsoleUI;

public class ShowAllSuppliers extends Command{
    public ShowAllSuppliers(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Показать всех поставщиков";
    }

    @Override
    public void execute() {
        consoleUi.showAllSuppliers();
    }
}
