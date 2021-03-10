package src;

import java.util.ArrayList;

public class product {
    private String nameProduct;
    private String idProduct;
    private double price;
    private int numberOfProduct;
    private ArrayList<shipment> listShipment  ;
    public product (String nameProduct,String idProduct,double price){
        this.nameProduct=nameProduct;
        this.idProduct=idProduct;
        this.price=price;
        this.listShipment=new ArrayList<shipment>();
        this.numberOfProduct =0;
    }
    public product(product Product){
        this.nameProduct=Product.nameProduct;
        this.idProduct=Product.idProduct;
        this.price =Product.price;
        this.listShipment=Product.listShipment;
        this.numberOfProduct=Product.numberOfProduct;
    }
    public void addShipment(shipment Shipment){
        listShipment.add(Shipment);
        this.numberOfProduct =this.numberOfProduct +Shipment.getAmountOfProduct();
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int compareTo(product x){
        return this.nameProduct.compareTo(x.nameProduct);
    }
}
