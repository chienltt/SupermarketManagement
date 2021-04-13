package src;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;

public class bill {
    private String idBill;
    private String stateBill;
    private ArrayList<order> listOrders;
    private double totalCost;
    public bill(String idBill){
        this.idBill=idBill;
        this.stateBill= "Unpaid";
        this.listOrders=new ArrayList<order>();
        this.totalCost=0;
    }
    public void addOrders(order Order){
        listOrders.add(Order);
        totalCost=totalCost+Order.getTotalOrderCost();
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getIdBill() {
        return idBill;
    }

    public String getStateBill() {
        return stateBill;
    }

    public void setStateBill(String stateBill) {
        this.stateBill = stateBill;
    }
}
