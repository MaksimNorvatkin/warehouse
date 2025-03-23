package model.repository;

import model.entity.Item;
import model.entity.NameProdukt;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Item> invoce;
    private long nextId;

    public Warehouse() {
        invoce = new ArrayList<>();
        nextId = 1;
    }

    public Item add(Item item) {
        invoce.add(item);
        return item;
    }

    public List<String> allProduct() {
        List<String> products = new ArrayList<>();
        for (Item item : invoce) {
            String p = item.getProduct();
            products.add(p);
        }
        return products;

    }

    public List<String> allSupplier() {
        List<String> suppliers = new ArrayList<>();
        for (Item item : invoce) {
            suppliers.add(item.getSupplier());
        }
        return suppliers;
    }

    public List<String> nameProduct(NameProdukt produkt) {
        List<String> produkts = new ArrayList<>();
        for (Item item : invoce) {
            if (item.getProduct().equals(produkt.getName())) {
                String itemString = "Наименование продукта: " + item.getProduct() + "Количество: " + item.getItemProduct()
                        + "Цена за едю: " + item.getPrice() + "Всего: " + item.getPriceItem();
                produkts.add(itemString);
            }
        }
        return produkts;
    }
}
