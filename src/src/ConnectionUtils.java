package src;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionUtils {

    private static final String userName = "root";
    private static final String password = "Chien8bltt";
    // jdbc:mysql://hostname:port/dbname
    private static final String connectionURL = "jdbc:mysql://localhost:3306/supermarketdatabase";

    public static Connection openConnection()  {
        // 1. Load Driver
        // Class.forName("com.mysql.jdbc.Driver");
        try
        {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // 2. Open connection
            return DriverManager.getConnection(connectionURL, userName, password);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("error");
            return null;
        }
    }
    public static ArrayList getDataProducts(){
        try{
            ArrayList<product> listProducts = new ArrayList<product>();

            String sqlSelectProducts = "SELECT * FROM products ";
            Connection con = ConnectionUtils.openConnection();
            Statement st = con.createStatement();
            ResultSet resultProducts=st.executeQuery(sqlSelectProducts);
            while (resultProducts.next()){
                product p=new product(resultProducts.getString(2),resultProducts.getString(1),resultProducts.getDouble(4),resultProducts.getInt(5));
                String sqlSelectShipments = "SELECT * FROM shipments where  productId="+"'"+p.getIdProduct()+"'";
//                ResultSet resultShipments= st.executeQuery(sqlSelectShipments);
//                while (resultShipments.next()){
//                    System.out.println(resultShipments.getString(2));
//                }
                listProducts.add(p);
            }
            for (int i=0;i< listProducts.size();i++){
                String sqlSelectShipments = "SELECT * FROM shipments where  productId="+"'"+listProducts.get(i).getIdProduct()+"'";
                ResultSet resultShipments= st.executeQuery(sqlSelectShipments);
                while (resultShipments.next()){
                    shipment s= new shipment(listProducts.get(i),resultShipments.getString(4),resultShipments.getInt(5),
                            resultShipments.getString(2),resultShipments.getString(3));
                    listProducts.get(i).addShipment(s);
                }
            }
            return listProducts;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("error");
            return null;
        }
    }
    public static void updateDataProducts(product p){
        try{

//            String sqlUpdate = "UPDATE products SET quantityInStock = "+"'"+p.getNumberOfProduct()+"'"+" , "+"price = " +"'"+p.getPrice()+"'"+" WHERE"+" productId="+p.getIdProduct();
            String sqlUpdate = "UPDATE products SET "+"price='"+ p.getPrice() + "' WHERE productId = '"+p.getIdProduct()+"' ";
            Connection con = ConnectionUtils.openConnection();
            Statement st = con.createStatement();
            st.executeUpdate(sqlUpdate);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("error");
        }
    }

}