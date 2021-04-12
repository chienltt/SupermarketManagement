package src;

public class productInfo {
    protected String idProduct;
    protected String nameProduct;
    protected double price;
    protected int dateToExpired;
    public productInfo (String nameProduct,String idProduct,double price,int dateToExpired){
        this.nameProduct=nameProduct;
        this.idProduct=idProduct;
        this.price=price;
        this.dateToExpired=dateToExpired;
    }
    public productInfo(productInfo Product){
        this.nameProduct=Product.nameProduct;
        this.idProduct=Product.idProduct;
        this.price =Product.price;
        this.dateToExpired= Product.dateToExpired;
    }

    public void setDateToExpired(int dateToExpired) {
        this.dateToExpired = dateToExpired;
    }

    public int getDateToExpired() {
        return dateToExpired;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int compareTo(productInfo x){
        return this.nameProduct.compareTo(x.nameProduct);
    }
}
