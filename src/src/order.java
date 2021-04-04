package src;

public class order  {
    private int numbers;
    private String orderName;
    private int orderPrice;
    private String orderId;
    public order(String orderName,String orderId,int orderPrice,int numbers){
        this.orderName= orderName;
        this.orderId=orderId;
        this.orderPrice=orderPrice;
        this.numbers=numbers;
    }
    public int getTotalCost(){
        return numbers*orderPrice;
    }
}
