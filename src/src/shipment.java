package src;


public class shipment extends productInfo{
//    private String nameProduct;
//    private String idProduct;
//    private double price;
    private String shipmentID;
    private int amountOfProduct;
    private String receptionDate;
    private String expirationDate;
//    private String shipmentID; //             id_ship
    public shipment( String nameProduct,String idProduct,int price,String shipmentID,  int amountOfProduct, String receptionDate,String expirationDate,int dateToExpired){
//        this.shipmentID=shipmentID;
        super(idProduct, nameProduct, price,dateToExpired);
        this.shipmentID=shipmentID;
        this.amountOfProduct = amountOfProduct;
        this.receptionDate= receptionDate;
        this.expirationDate=expirationDate;
    }

    public shipment(product Product,String shipmentID,int amountOfProduct, String receptionDate,String expirationDate){
        super(Product.idProduct, Product.nameProduct, Product.price,Product.dateToExpired);
        this.shipmentID=shipmentID;
        this.amountOfProduct = amountOfProduct;
        this.receptionDate= receptionDate;
        this.expirationDate=expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getReceptionDate() {
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
