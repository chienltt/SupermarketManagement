package src;

import java.util.ArrayList;
import java.util.Collections;

public class ControllerData {

    public static ArrayList<product> listProducts = new ArrayList<product>();
    public static ArrayList<user> listUsers= new ArrayList<user>();


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

}
