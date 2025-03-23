package controller;

import model.servise.Service;
import view.View;

public class ItemControllerImpl implements ItemController {

    private final View view;
    private final Service service;

    public ItemControllerImpl(View view) {
        super();
        this.view = view;
        service = new Service(this);
    }
    public void addItem (String product, Double price,
                         Integer item, String supplier){
        String infoString = service.addItem(product, price, item, supplier);
        view.printAnswer(infoString);
    }
}
