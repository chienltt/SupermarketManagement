package src;

import java.util.ArrayList;
import java.util.Collections;

public class ControllerData {

    public static ArrayList<product> listProducts = new ArrayList<product>();
    public static ArrayList<user> listUsers= new ArrayList<user>();
    public static ArrayList<bill> listRemainingBill= new ArrayList<bill>();

    public static void testAddProduct(){
        product a=new product("bim bim","ăduiawuid",10,10);
        product b=new product("sua","ăduioawda1",15,50);
        product c=new product("keo","ăqdawdawid",5,0);
        shipment a1=new shipment(a,"awdaădawwd",50, new date(2000,2000,2000), new date(1000,1000,1000));
        shipment a2= new shipment(a,"sgdirgsjif",70, new date(20,20,10), new date(15,20,15));
        shipment b1= new shipment (b,"cbakcawđăd",40, new date(100,100,20), new date(30,30,30));
        a.addShipment(a1);
        a.addShipment(a2);
        b.addShipment(b1);
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
//
//    public static void addShipment(shipment Shipment){
//        ControllerData.listShipment.add(Shipment);
//        sortListShipment();
//    }
    public static void addUser(user User){
        ControllerData.listUsers.add(User);
        sortListUser();
    }
//    public static boolean addShipmentOfProduct(product Product,shipment Shipment){
//        for(int i = 0; i< ControllerData.listProducts.size(); i++){
//            if(ControllerData.listProducts.get(i).getIdProduct()==Product.getIdProduct() )
//            {
//                ControllerData.listProducts.get(i).addShipment(Shipment);
//                return true;
//            }
//        }
//        return false;
//    }

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
