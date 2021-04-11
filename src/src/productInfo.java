package src;

public class productInfo {
    protected String idProduct;
    protected String nameProduct;
    protected double price;
    public productInfo (String nameProduct,String idProduct,double price){
        this.nameProduct=nameProduct;
        this.idProduct=idProduct;
        this.price=price;
    }
    public productInfo(productInfo Product){
        this.nameProduct=Product.nameProduct;
        this.idProduct=Product.idProduct;
        this.price =Product.price;
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
