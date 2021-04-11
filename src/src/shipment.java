package src;


public class shipment extends productInfo{
//    private String nameProduct;
//    private String idProduct;
//    private double price;
    private String shipmentID;
    private int amountOfProduct;
    private date receptionDate;
    private date expirationDate;
//    private String shipmentID; //             id_ship
    public shipment( String nameProduct,String idProduct,int price,String shipmentID,  int amountOfProduct, date receptionDate,date expirationDate){
//        this.shipmentID=shipmentID;
        super(idProduct, nameProduct, price);
        this.shipmentID=shipmentID;
        this.amountOfProduct = amountOfProduct;
        this.receptionDate= new date(receptionDate);
        this.expirationDate=new date(expirationDate);
    }

    public shipment(productInfo Product,String shipmentID,int amountOfProduct, date receptionDate,date expirationDate){
        super(Product.idProduct, Product.nameProduct, Product.price);
        this.shipmentID=shipmentID;
        this.amountOfProduct = amountOfProduct;
        this.receptionDate= new date(receptionDate);
        this.expirationDate=new date(expirationDate);
    }

    public date getExpirationDate() {
        return expirationDate;
    }

    public date getReceptionDate() {
        return receptionDate;
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }

    public void setAmountOfProduct(int amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }

        public String getShipmentID() {
        return shipmentID;
    }


}
