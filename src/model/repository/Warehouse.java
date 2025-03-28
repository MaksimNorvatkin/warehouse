package model.repository;

import model.entity.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Warehouse {
    private List<Item> invoice;
    private int nextId;

    public Warehouse() {
        invoice = new ArrayList<>();
        nextId = 1;
    }

    public Item add(Item item) {
        item.setItemId(nextId);
        invoice.add(item);
        nextId++;
        return item;
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(invoice);
    }

    public List<String> getAllSuppliers() {
        if (invoice == null || invoice.isEmpty()) {
            return Collections.emptyList();
        }

        return invoice.stream()
                .map(Item::getSupplier)
                .filter(Objects::nonNull) // фильтрация null-значений
                .distinct() // убираем дубликаты
                .sorted() // сортируем по алфавиту
                .collect(Collectors.toList()); // собираем в List<String>
    }

    public List<Item> findItemsByName(String productName) {
        return invoice.stream()
                .filter(item -> item.getProduct().equalsIgnoreCase(productName))
                .collect(Collectors.toList());
    }

    public void moveItem(int itemId, int newWarehouseId) {
        invoice.stream()
                .filter(item -> item.getItemId().equals(itemId))
                .findFirst()
                .ifPresent(item -> item.setIdWarehous(newWarehouseId));
    }
}
