package model.entity;

public class Item {
    private Integer id;
    private Integer idItem;
    private String product;
    private Double price;
    private Integer itemProduct;
    private Double priceItem;
    private String supplier;

    public Item(String product, Double price, Integer item, String supplier) {

        this.product = product;
        this.price = price;
        this.itemProduct = item;
        this.supplier = supplier;
    }

    //Гетеры
    public Integer getId() {
        return id;
    }

    public Integer getIdItem() {
        return idItem;
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

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
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
        return "Item{" +
                "id=" + id +
                ", idItem=" + idItem +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", itemProduct=" + itemProduct +
                ", priceItem=" + priceItem +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}
