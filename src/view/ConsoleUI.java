package view;

import controller.ItemController;
import controller.ItemControllerImpl;

import java.util.Scanner;

public class ConsoleUI implements View{

    private final Scanner scanner;
    private final ItemController controller;
    private final Menu menu;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        controller = new ItemControllerImpl(this);
        menu = new Menu(this);
        work = true;
    }
    private void execute() {
        System.out.print("Введите соответстующий пункт меню: ");
        int numMenu = scanner.nextInt();
        scanner.nextLine();
        menu.execute(numMenu);
    }
    public void run() {
        System.out.print("\nНакладная\n");
        while(work) {
            System.out.println(menu.printMenu());
            execute();
        }
        System.out.println("Отгрузка завершена.");
    }
    public void addItem() {
        System.out.print("Введите имя постовщика: ");
        String supplier = scanner.nextLine();

        boolean continueAdding = true;
        while (continueAdding) {
            System.out.print("\nВведите наименование товара: ");
            String product = scanner.nextLine();
            System.out.print("\nВведите цену за единицу товара: ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("\nВведите количество товара: ");
            int item = Integer.parseInt(scanner.nextLine());
            System.out.print("\nВведите номер склада(Их два: склад№1 и склад№2): ");
            int idWarehous = Integer.parseInt(scanner.nextLine());
            System.out.println();
            controller.addItem(idWarehous, product, price, item, supplier);

            System.out.print("Продолжить добавление товаров в накладную? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                continueAdding = false;
            }
        }
    }

    @Override
    public void printAnswer(String info) {

    }
}
