package lection_11_SOLID_lab.solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.orderItemsPerSku;

public abstract class OrderItem {
    private String sku;

    private int quantity;

    public abstract double getItemPrice();

    public String getSku() {
        return this.sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
