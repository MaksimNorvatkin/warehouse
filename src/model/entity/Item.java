package model.entity;

public class Item {
    private Integer id;
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
    public Integer getId() {
        return id;
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

    public Double getPriceItem() {
        return priceItem;
    }

    public String getSupplier() {
        return supplier;
    }

    //Сеттеры
    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdWarehous(Integer idWarehous) {
        this.idWarehous = idWarehous;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setItemProduct(Integer itemProduct) {
        this.itemProduct = itemProduct;
    }

    private double calculatePriceItem() {
        return price * itemProduct;
    }

    public void setPriceItem(Double priceItem) {
        this.priceItem = priceItem;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return String.format(
                "Товар: %-15s | Цена: %-8.2f | Количество: %-4d | Сумма: %-8.2f | Поставщик: %-15s | Склад: %d",
                product, price, itemProduct, price * itemProduct, supplier, idWarehous
        );
    }
}
