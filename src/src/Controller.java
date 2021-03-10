package src;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {

    public static ArrayList<product> listProducts = new ArrayList<product>();
    public static ArrayList<user> listUsers= new ArrayList<user>();
    public static ArrayList<bill> listRemainingBill= new ArrayList<bill>();

    public static void sortListProducts(){
        Collections.sort(listProducts,(pro1,pro2)-> pro1.compareTo(pro2));
    }
    public static void sortListUser(){
        Collections.sort(listUsers,(user1,user2)->user1.compareTo(user2));
    }

    public static void addProduct(product Product){
        Controller.listProducts.add(Product);
        sortListProducts();
    }
    public static void addUser(user User){
        Controller.listUsers.add(User);
        sortListUser();
    }
    public static boolean addShipmentOfProduct(product Product,shipment Shipment){
        for(int i=0;i<Controller.listProducts.size();i++){
            if(Controller.listProducts.get(i).getIdProduct()==Product.getIdProduct() )
            {
                Controller.listProducts.get(i).addShipment(Shipment);
                return true;
            }
        }
        return false;
    }

    public static void createBill(ArrayList<order> Orders,String idBill){
        bill Bill =new bill(idBill);
        for(int i=0;i<Orders.size();i++)
        {
            Bill.addOrders(Orders.get(i));
        }
        Controller.listRemainingBill.add(Bill);
    }

    public static boolean payBill(bill Bill){
        for (int i=0;i<Controller.listRemainingBill.size();i++){
            if(Controller.listRemainingBill.get(i).getIdBill()== Bill.getIdBill())
            {
                Controller.listRemainingBill.remove(i);
                return true;
            }
        }
        return false;
    }
}
