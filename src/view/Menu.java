package view;

import view.command.AddItem;
import view.command.Command;
import view.command.ShowAllItems;
import view.command.ShowAllSuppliers;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> commands;

    public Menu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddItem(consoleUI));
        commands.add(new ShowAllItems(consoleUI));
        commands.add(new ShowAllSuppliers(consoleUI));
    }
    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nРегистрация поступления\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1)
                    .append(". ")
                    .append(commands.get(i).getMenuText())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commands.size();
    }
}
