package view.command;

import view.ConsoleUI;

public class ShowProductsByName extends Command{
    public ShowProductsByName(ConsoleUI consoleUi) {
        super(consoleUi);
        menuText = "Поиск товара по названию";
    }

    @Override
    public void execute() {
        consoleUi.showProductsByName();
    }
}
