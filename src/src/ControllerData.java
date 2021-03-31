package src;

import java.util.ArrayList;
import java.util.Collections;

public class ControllerData {

    public static ArrayList<product> listProducts = new ArrayList<product>();
    public static ArrayList<user> listUsers= new ArrayList<user>();
    public static ArrayList<bill> listRemainingBill= new ArrayList<bill>();

    public static void testAddProduct(){
        product a=new product("bim bim","awdawd",5.0);
        product b= new product("sua","sgdirgsjif",7.5);
        product c= new product ("mitom","cbakcawd",4.0);
        a.addShipment(new shipment("awdaywd",100,new date(5,5,5),new date(1,1,1)));
        a.addShipment(new shipment("naiwdhaiwd",50,new date(50,50,50),new date(10,10,10)));
        b.addShipment(new shipment("awdaywd",500,new date(56,6,7),new date(3,1,2)));
        ControllerData.listProducts.add(a);
        ControllerData.listProducts.add(b);
        ControllerData.listProducts.add(c);
    }

    public static void sortListProducts(){
        Collections.sort(listProducts,(pro1,pro2)-> pro1.compareTo(pro2));
    }
    public static void sortListUser(){
        Collections.sort(listUsers,(user1,user2)->user1.compareTo(user2));
    }

    public static void addProduct(product Product){
        ControllerData.listProducts.add(Product);
        sortListProducts();
    }
    public static void addUser(user User){
        ControllerData.listUsers.add(User);
        sortListUser();
    }
    public static boolean addShipmentOfProduct(product Product,shipment Shipment){
        for(int i = 0; i< ControllerData.listProducts.size(); i++){
            if(ControllerData.listProducts.get(i).getIdProduct()==Product.getIdProduct() )
            {
                ControllerData.listProducts.get(i).addShipment(Shipment);
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
        ControllerData.listRemainingBill.add(Bill);
    }

    public static boolean payBill(bill Bill){
        for (int i = 0; i< ControllerData.listRemainingBill.size(); i++){
            if(ControllerData.listRemainingBill.get(i).getIdBill()== Bill.getIdBill())
            {
                ControllerData.listRemainingBill.remove(i);
                return true;
            }
        }
        return false;
    }
}
