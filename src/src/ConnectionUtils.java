package src;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionUtils {

    private static final String userName = "root";
    private static final String password = "gnctt197320";
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

            String sqlSelect = "SELECT * FROM products";
            Connection con = ConnectionUtils.openConnection();
            Statement st = con.createStatement();
            ResultSet result=st.executeQuery(sqlSelect);
            while (result.next()){
                product p=new product(result.getString(1),result.getString(2),result.getDouble(5),result.getInt(4));
                listProducts.add(p);
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
            String sqlUpdate = "UPDATE products SET quantityInStock='50',price='5000.0' WHERE productId = 'P1' ";
            Connection con = ConnectionUtils.openConnection();
            Statement st = con.createStatement();
            st.executeUpdate(sqlUpdate);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("error");
        }
    }

}