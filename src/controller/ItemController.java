package controller;

import model.entity.Item;

import java.util.List;

import java.awt.*;

public interface ItemController {
    void addItem (Integer idWarehous, String product, Double price,
                  Integer item, String supplier);
    List<Item> getAllItems();
    List<String> getAllSuppliers();
}
