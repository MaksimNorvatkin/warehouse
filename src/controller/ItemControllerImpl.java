package controller;

import model.entity.Item;
import model.servise.Service;
import model.repository.Warehouse;
import view.View;

import java.util.List;

public class ItemControllerImpl implements ItemController {

    private View view;
    private final Service service;

    public ItemControllerImpl(View view) {
        this.view = view;
        this.service = new Service(new Warehouse());
    }
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void addItem(Integer idWarehous, String product, Double price,
                        Integer item, String supplier) {
        String infoString = service.addItem(idWarehous, product, price, item, supplier);
        view.printAnswer(infoString);
    }
    @Override
    public List<Item> getAllItems() {
        return service.getAllItems();
    }

    @Override
    public List<String> getAllSuppliers() {
        return service.getAllSuppliers();
    }

    @Override
    public List<Item> findItemsByName(String productName) {
        return service.findItemsByName(productName);
    }

    @Override
    public void moveItems(int itemId, int newWarehouseId)  {
        service.transferItems(itemId,newWarehouseId);
    }
}
