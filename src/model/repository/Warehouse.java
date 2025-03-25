package model.repository;

import model.entity.Item;
import model.entity.NameProdukt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Warehouse {
    private List<Item> invoice;
    private long nextId;

    public Warehouse() {
        invoice = new ArrayList<>();
        nextId = 1;
    }

    public Item add(Item item) {
        invoice.add(item);
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

    public List<String> nameProduct(NameProdukt produkt) {
        List<String> produkts = new ArrayList<>();
        for (Item item : invoice) {
            if (item.getProduct().equals(produkt.getName())) {
                String itemString = "Наименование продукта: " + item.getProduct() + "Количество: " + item.getItemProduct()
                        + "Цена за едю: " + item.getPrice() + "Всего: " + item.getPriceItem();
                produkts.add(itemString);
            }
        }
        return produkts;
    }
}
