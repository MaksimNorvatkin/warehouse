package model.entity;

public class Item {
    private Integer itemId;
    private Integer idWarehous;
    private String product;
    private Double price;
    private Integer itemProduct;
    private Double priceItem;
    private String supplier;

    public Item(Integer idWarehous, String product, Double price, Integer item, String supplier) {
        this.idWarehous = idWarehous;
        this.product = product;
        this.price = price;
        this.itemProduct = item;
        this.supplier = supplier;
    }

    //Гетеры
    public Integer getItemId() {
        return itemId;
    }

    public Integer getIdWarehous() {
        return idWarehous;
    }

    public String getProduct() {
        return product;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getItemProduct() {
        return itemProduct;
    }

    public String getSupplier() {
        return supplier;
    }

    //Сеттеры
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setIdWarehous(Integer idWarehous) {
        this.idWarehous = idWarehous;
    }


    @Override
    public String toString() {
        return String.format(
                "Товар: %-15s | Цена: %-8.2f | Количество: %-4d | Сумма: %-8.2f | Поставщик: %-15s | Склад: %d",
                product, price, itemProduct, price * itemProduct, supplier, idWarehous
        );
    }
}
