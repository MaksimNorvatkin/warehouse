package controller;

import model.entity.Item;

import java.util.List;

public interface ItemController {
    void addItem (Integer idWarehous, String product, Double price,
                  Integer item, String supplier);
    List<Item> getAllItems();
    List<String> getAllSuppliers();
    List<Item> findItemsByName(String productName);
    public void moveItems(int itemId, int newWarehouseId) ;
}
