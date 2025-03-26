package model.servise;

import controller.ItemControllerImpl;
import model.entity.Item;
import model.repository.Warehouse;
import java.util.List;

public class Service {
    private final Warehouse repository;
    private ItemControllerImpl controllerImpl;

    public Service(Warehouse repository) {
        this.repository = new Warehouse();
    //    this.controllerImpl = itemController;
    }

    public String addItem(Integer idWarehous, String product, Double price,
                          Integer item, String supplier) {
        Item itemInvoice = new Item(idWarehous, product, price, item, supplier);
        return repository.add(itemInvoice).toString();
    }
    public List<Item> getAllItems() {
        return repository.getAllItems();
    }
    public List<String> getAllSuppliers(){
        return repository.getAllSuppliers();
    }
    public List<Item> findItemsByName(String productName){
        return repository.findItemsByName(productName);
    }
}
