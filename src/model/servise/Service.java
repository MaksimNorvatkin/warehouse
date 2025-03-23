package model.servise;

import controller.ItemControllerImpl;
import model.entity.Item;
import model.repository.Warehouse;

public class Service {
    private final Warehouse repository;
    private ItemControllerImpl controllerImpl;

    public Service(ItemControllerImpl itemController) {
        this.repository=new Warehouse();
        this.controllerImpl=itemController;
    }
    public String addItem(Integer idWarehous, String product, Double price,
                          Integer item, String supplier){
        Item itemInvoice = new Item(idWarehous, product, price, item, supplier);
        return repository.add(itemInvoice).toString();
    }
}
