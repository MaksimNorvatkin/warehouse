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
    public void addItem(Integer idWarehous, String product, Double price,
                        Integer item, String supplier) {
        String infoString = service.addItem(idWarehous, product, price, item, supplier);
        view.printAnswer(infoString);
    }
    @Override
    public List<Item> getAllItems() {
        return service.getAllItems();
    }
}
