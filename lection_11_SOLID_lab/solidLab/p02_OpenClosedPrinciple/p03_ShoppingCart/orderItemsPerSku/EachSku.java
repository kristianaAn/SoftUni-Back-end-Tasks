package lection_11_SOLID_lab.solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart.orderItemsPerSku;

public class EachSku extends OrderItem {
     public double getItemPrice() {
          return this.getQuantity() * 5.0;
     }
}
