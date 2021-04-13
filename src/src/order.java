package src;

import java.util.PrimitiveIterator;

public class order extends productInfo {
    private int STT_Order;
    private int amountOfOrder;
    private double totalOrderCost;
//    public order () {
//
//    }
    public order(String nameProduct, String idProduct, double price,int dateToExpired,int STT_Order, int amountOfOrder) {
        super( idProduct,nameProduct, price,dateToExpired);
        this.STT_Order = STT_Order;
        this.amountOfOrder = amountOfOrder;
        this.totalOrderCost = amountOfOrder*price;
    }
    public order(product p ,int STT_Order, int amountOfOrder){
        super(p.getIdProduct(),p.getNameProduct(),p.getPrice(),p.getDateToExpired());
        this.STT_Order = STT_Order;
        this.amountOfOrder = amountOfOrder;
        this.totalOrderCost = amountOfOrder*price;
    }

    public void setAmountOfOrder(int amountOfOrder) {
        this.amountOfOrder = amountOfOrder;
    }

    public void setSTT_Order(int STT_Order) {
        this.STT_Order = STT_Order;
    }

    public int getAmountOfOrder() {
        return amountOfOrder;
    }

    public int getSTT_Order() {
        return STT_Order;
    }


    public void setTotalOrderCost(double totalOrderCost) {
        this.totalOrderCost = totalOrderCost;
    }

    public double getTotalOrderCost() {
        return amountOfOrder * getPrice();
    }

}
