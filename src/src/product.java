package src;

import java.util.ArrayList;

public class product {

    private String nameProduct;
    private String idProduct;
    private double price;
    private int numberOfProduct;
    private String state;
    private ArrayList<shipment> listShipment  ;
    public product (String nameProduct,String idProduct,double price){
        this.nameProduct=nameProduct;
        this.idProduct=idProduct;
        this.price=price;
        this.listShipment=new ArrayList<shipment>();
        this.numberOfProduct =0;
        this.state="Het hang";
    }
    public product(product Product){
        this.nameProduct=Product.nameProduct;
        this.idProduct=Product.idProduct;
        this.price =Product.price;
        this.listShipment=Product.listShipment;
        this.numberOfProduct=Product.numberOfProduct;
        this.state=Product.state;
    }
    public void addShipment(shipment Shipment){
        listShipment.add(Shipment);
        this.numberOfProduct =this.numberOfProduct +Shipment.getAmountOfProduct();
        if (this.numberOfProduct != 0) this.state="Con hang";
        else this.state="Het hang";
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public String getState123() {
        return state;
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
