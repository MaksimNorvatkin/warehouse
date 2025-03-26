package view.command;

import view.ConsoleUI;
public class ExitCommand extends Command{
    public ExitCommand(ConsoleUI consoleUI) {
        super(consoleUI);
        menuText = "Выход";
    }

    @Override
    public void execute() {
        consoleUi.exit();
    }
}
