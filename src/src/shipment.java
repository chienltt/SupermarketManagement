package src;


public class shipment {
    private String nameProduct;
    private String idProduct;
    private double price;
    private int numberOfProduct;
    private date receptionDate;
    private date expirationDate;
    private String shipmentID;
    public shipment( String shipmentID,int amountOfProduct, date receptionDate
            ,date expirationDate){
        this.shipmentID=shipmentID;
        this.numberOfProduct=amountOfProduct;
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
        return numberOfProduct;
    }

    public String getShipmentID() {
        return shipmentID;
    }
}
