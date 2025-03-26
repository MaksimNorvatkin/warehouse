package view;

import controller.ItemController;
import model.entity.Item;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleUI implements View {

    private final Scanner scanner;
    public ItemController controller;
    private final Menu menu;
    private boolean work;

    public ConsoleUI(ItemController controller) {
        scanner = new Scanner(System.in);
        this.controller = controller;
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
        System.out.print("\nНакладная - система управления складом\"\n");
        while (work) {
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

    public void showAllItems() {
        List<Item> items = controller.getAllItems();
        if (items.isEmpty()) {
            printAnswer("Склад пуст.");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Содержимое склада:\n");
            for (Item item : items) {
                sb.append(formatItem(item)).append("\n");
            }
            printAnswer(sb.toString());
        }
    }

    public void showAllSuppliers() {
        List<String> suppliers = controller.getAllSuppliers();
        if (suppliers.isEmpty()) {
            printAnswer("Список поставщиков пуст.");
        } else {
            String result = suppliers.stream()
                    .map(this::formatSupplier)
                    .collect(Collectors.joining("\n", "Список поставщиков:\n", ""));
            printAnswer(result);
        }
    }

    public void showProductsByName() {
        System.out.print("Введите название товара: ");
        String name = scanner.nextLine();
        List<Item> nameItems = controller.findItemsByName(name);
        if (nameItems.isEmpty()) {
            printAnswer("Товар не найден");
        } else {
            String result = nameItems.stream()
                    .map(this::formatItem)
                    .collect(Collectors.joining("\n", "Найденные товары:\n", ""));
            printAnswer(result);
        }
    }

    public void moveItemsBetweenWarehouses() {
        // 1. Получаем все товары
        List<Item> allItems = controller.getAllItems();

        System.out.print("Введите номер склада (1 или 2) откуда перемещаем: ");
        int fromWarehouse = scanner.nextInt();
        scanner.nextLine();

        // 3. Фильтруем товары по складу и выводим
        List<Item> warehouseItems = allItems.stream()
                .filter(item -> item.getIdWarehous() == fromWarehouse)
                .collect(Collectors.toList());

        if (warehouseItems.isEmpty()) {
            System.out.println("На этом складе нет товаров!");
            return;
        }
        warehouseItems.forEach(item ->
                System.out.println(item.getItemId() + ". " + item.getProduct())
        );

        // 4. Выбор товара
        System.out.print("Введите ID товара для перемещения: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите номер склада (1 или 2) куда перемещаем: ");
        int toWarehouse = scanner.nextInt();
        scanner.nextLine();

        // 6. Перемещение
        controller.moveItems(itemId, toWarehouse);
        System.out.println("Товар перемещён!");
    }
    public void exit() {
        work = false;
        System.out.println("Работа склада завершена.");
    }

    private String formatItem(Item item) {
        return String.format(
                "Номер товара: %d |Товар: %-15s | Цена: %-8.2f | Кол-во: %-4d | Сумма: %-8.2f | Поставщик: %-15s | Склад: %d",
                item.getItemId(), item.getProduct(), item.getPrice(),
                item.getItemProduct(), item.getPrice() * item.getItemProduct(),
                item.getSupplier(), item.getIdWarehous()
        );
    }

    private String formatSupplier(String supplier) {
        return String.format(
                "Поставщик: %-15s", supplier);
    }

    @Override
    public void printAnswer(String info) {
        System.out.println(info);
    }
}
