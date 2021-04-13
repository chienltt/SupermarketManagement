package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;

import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import src.*;

public class Controller implements Initializable {

    //Login_var
    private Boolean Logined = false;

    private Boolean orderVisible=false;

    @FXML
    private JFXButton Login;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton Login2;
    @FXML
    private JFXButton Close_Button;
    @FXML
    private AnchorPane Login_tab;
    @FXML
    private Label notify_login;

    //forget_pass
    @FXML
    private JFXButton forget_pass;
    @FXML
    private AnchorPane notify_forget_pas;
    @FXML
    private Label content;
    @FXML
    private JFXButton Ok_button;

    @FXML
    private JFXButton Cancel;

// Menu_var

    @FXML
    private JFXButton Home;

    @FXML
    private JFXButton Order_button;

    @FXML
    private JFXButton Buy_product;

    @FXML
    private JFXButton product;

    @FXML
    private JFXButton credit;

    @FXML
    private JFXButton employees;

    @FXML
    private AnchorPane Home_1;

    @FXML
    private AnchorPane Order_tab;

    @FXML
    private AnchorPane Buy_product_1;

    @FXML
    private AnchorPane product_1;

    @FXML
    private AnchorPane credit_1;

    @FXML
    private AnchorPane employees_1;

    @FXML
    private Label LB_Name;

    //product_1_table
    @FXML
    private TableView<product> product_table;
    @FXML
    private TableColumn<product, String> macol;
    @FXML
    private TableColumn<product, String> tencol;
    @FXML
    private TableColumn<product, Integer> soluongcol;
    @FXML
    private TableColumn<product, Double> giacol;
    @FXML
    private TableColumn<product, String> tinhtrangcol;

    //product textfield

    @FXML
    private TextField maid_pro;
    @FXML
    private TextField tenid_pro;
    @FXML
    private TextField soluongid_pro;
    @FXML
    private TextField giaid_pro;
    @FXML
    private TextField tinhtrangid_pro;

    //detail_tab//dinh dang table o day;




    @FXML
    private Button detail_pro;

    @FXML
    private Button Close_detail;

    @FXML
    private TableView<shipment> detail_table;

    private ObservableList<shipment> shipmentsList;

    private String currentProductIdChoice;

    @FXML
    private TableColumn<shipment, String> macolproduct2;

    @FXML
    private TableColumn<shipment, String > tencol2;
    @FXML
    private TableColumn< shipment, String> macolshipment2;

    @FXML
    private TableColumn<shipment, Integer> soluongcol2;

    @FXML
    private TableColumn<shipment, String> ngaynhapcol2;

    @FXML
    private TableColumn<shipment, String> ngayhethancol2;









    @FXML
    private TextField chitietlohang;
    @FXML
    private TextField search_text;

    @FXML
    private JFXButton search_button;

    private ObservableList<product> productsList;

    //Order_var

    @FXML
    private JFXButton Order_click;

    @FXML
    private AnchorPane Order_tab_2;

    @FXML
    private TableView<order> OrDer_table;

    @FXML
    private TableColumn<order, Integer> STT_Order;

    @FXML
    private TableColumn<order, String> ID_Order;

    @FXML
    private TableColumn<order, String> Name_Order;


    @FXML
    private TableColumn<order, Integer> Price_Order;

    @FXML
    private TableColumn<order, Integer> Amount_Order;

    @FXML
    private TableColumn<order, Integer> Sum_Order;

    private ObservableList<order> ordersList;
   //pay_var_order
    @FXML
    private JFXButton Paid_button_Order;

    @FXML
    private AnchorPane Payment_tab;
    @FXML
    private JFXButton Cancel_Paid_btn;

    @FXML
    private TextField Paid_text_Order;

    @FXML
    private TextField ToTal_text_Order;

    @FXML
    private TextField ExCash_text_Order;
    // text_Order
    @FXML
    private TextField id_product_Order; //text_id

    @FXML
    private TextField number_Order; //text_so_luong

    @FXML
    private JFXButton Add_btn_Order;  // button_them

    @FXML
    private Label Total_money_Order; // text_tong_tien


    // Signal_var
    public Boolean check_select = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //ss;
        this.Login_event();
        this.Order_event();
        this.create_order();
        this.setvalueColumnoftableProduct();
        this.setValueDetailProductTable();
        this.editproducttable();
        this.searchinproducttable();
        this.select_product();
    }
    // tao gia tri cho product_table
    public void setvalueColumnoftableProduct(){
        macol.setCellValueFactory(new PropertyValueFactory<product, String>("idProduct"));
        tencol.setCellValueFactory(new PropertyValueFactory<product, String>("nameProduct"));
        soluongcol.setCellValueFactory(new PropertyValueFactory<product, Integer>("numberOfProduct"));
        giacol.setCellValueFactory(new PropertyValueFactory<product, Double>("price"));
        tinhtrangcol.setCellValueFactory(new PropertyValueFactory<product, String>("state"));
        this.setProductlist();
    }

    public void setValueDetailProductTable(){
        macolproduct2.setCellValueFactory(new PropertyValueFactory<shipment,String>("idProduct"));
        tencol2.setCellValueFactory(new PropertyValueFactory<shipment, String>("nameProduct"));
        macolshipment2.setCellValueFactory(new PropertyValueFactory<shipment,String >("shipmentID"));
        soluongcol2.setCellValueFactory(new PropertyValueFactory<shipment,Integer>("amountOfProduct"));
        ngaynhapcol2.setCellValueFactory(new PropertyValueFactory<shipment,String>("receptionDate"));
        ngayhethancol2.setCellValueFactory(new PropertyValueFactory<shipment,String>("expirationDate"));
    }

    // tim kiem trong product_table
    public void searchinproducttable(){
        FilteredList<product> filteredData = new FilteredList<>(productsList, b -> true);
        search_text.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (employee.getIdProduct().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (employee.getNameProduct().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                else
                    return false; // Does not match.
            });
        });
        SortedList<product> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(product_table.comparatorProperty());
        product_table.setItems(sortedData);
    }


    // chinh sua trong product_table
    public void editproducttable(){
        product_table.setEditable(true);
        detail_table.setEditable(true);
//        macol.setCellFactory(TextFieldTableCell.forTableColumn());
        tencol.setCellFactory(TextFieldTableCell.forTableColumn());
//        soluongcol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        giacol.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
//        tinhtrangcol.setCellFactory(TextFieldTableCell.forTableColumn());
        soluongcol2.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        setProductlist();
    }

    public void setProductlist(){
        productsList= FXCollections.observableArrayList();
        ArrayList<product> listProducts= ConnectionUtils.getDataProducts();
        for (int i = 0; i< listProducts.size(); i++){
            productsList.add(listProducts.get(i));
        }
        TextFields.bindAutoCompletion(id_product_Order,listProductId());
        product_table.setItems(productsList);
    }
    public void setShipmentList(){
        shipmentsList=FXCollections.observableArrayList();
        for (int i=0;i<productsList.size();i++){
            if(productsList.get(i).getIdProduct()==currentProductIdChoice){
                for(int j=0;j<productsList.get(i).getListShipment().size();j++){
                    shipmentsList.add(productsList.get(i).getListShipment().get(j));
                }
            }
        }
        detail_table.setItems(shipmentsList);
    }

    public void Close_Click(AnchorPane tab, JFXButton but) {
        but.setOnMouseClicked(event -> {
            tab.setVisible(false);
        });
    }

    public void Open_Click(AnchorPane tab, JFXButton btn) {
        btn.setOnMouseClicked(event -> {
            tab.setVisible(true);
            orderVisible=true;
            ordersList=FXCollections.observableArrayList();

        });
    }

    public void search_Product_Click(){
        search_button.setOnMouseClicked(event -> {
            searchinproducttable();
        });
    }

    // Tab_dang_nhap
    public void Login_Forget(JFXButton login, AnchorPane Login_tab) {
        login.setOnMouseClicked(event -> {
            if (!Login_tab.isVisible()) {
                Login_tab.setVisible(true);
            } else {
                String user = username.getText();
                String pass = password.getText();
                //check_ki_tu_khi_dang_nh
                // xu_li_thong_tin_dang_nhap
                if (Check_key(user, pass, 4, 16) && (user.equals("gnctt") && pass.equals("191001"))) {

                    Login_tab.setVisible(false);
                    username.setText("");
                    password.setText("");
                    notify_login.setText("");
                    Logined = true;
                    if (Logined) {
                        Login2.setText("Đăng xuất");
                    } else {
                        Login2.setText("Đăng nhập");
                    }
                } else {
                    if (!Check_key(user, pass, 4, 16)) {
                        notify_login.setText("* tài khoản mật khẩu không đúng định dạng, không \n" +
                                "chứa kí tự đặc biệt, dài hơn 4 kí tự không quá 16 kí tự");
                    } else {
                        notify_login.setText("* tài khoản hoặc mật khẩu không chính xác vui lòg nhập lại \n" + "hoặc chọn quên mật khẩu");
                    }


                }

            }
        });
        forget_pass.setOnMouseClicked(event -> {
            String user = username.getText();
            notify_forget_pas.setVisible(true);
            Close_Click(notify_forget_pas, Ok_button);
            Close_Click(notify_forget_pas, Cancel);
            if (user.equals("gnctt")) {

                content.setText("          Đã gửi mật khẩu mới\n" +
                        "            tới gmail của bạn");
            } else {
                content.setText("          tài khoản chưa tồn tại\n" +
                        "            hãy đăng kí với quản lí");
            }
        });
    }
    //


    // Kiem_tra_dinh_dang_us_ps;

    public boolean Check_space(String a) {
        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) >= 65 && a.charAt(i) <= 90) || (a.charAt(i) >= 97 && a.charAt(i) <= 122) || (a.charAt(i) >= 48 && a.charAt(i) <= 57)) {

                return true;
            }
        }
        return false;
    }

    public boolean Check_key(String a, String b, int minlength, int maxlength) {
        if (a.length() <= minlength || b.length() <= minlength || a.length() >= maxlength || b.length() >= maxlength) {
            return false;
        } else {
            if (Check_space(a) && Check_space(b)) {
                return true;
            }
        }
        return false;
    }

    //get_text_khi_an_button
    public void get_Text(TextField a, TextField b, JFXButton btn) {
        btn.setOnMouseClicked(event -> {
            String a1 = a.getText();
            String resultId=new String();
            for (int i=0;i<a1.length();i++)
            {
                if(a1.charAt(i) != '(') resultId=resultId+a1.charAt(i);
                else break;
            }
            String b1 = b.getText();
            for (int i=0;i<productsList.size();i++){
                if(resultId.equals(productsList.get(i).getIdProduct())== true){
                    System.out.println(resultId + " " + b1);
                    if(Integer.parseInt(b1) <= productsList.get(i).getNumberOfProduct()) {
                        order o = new order(productsList.get(i),ordersList.size()+1,Integer.parseInt(b1) );
                        double totalMoney=0;
                        ordersList.add(o);
                        OrDer_table.setItems(ordersList);
                        for(int j=0 ; j<ordersList.size();j++){
                            totalMoney=totalMoney+ordersList.get(j).getTotalOrderCost();
                        }
                        Total_money_Order.setText(Double.toString(totalMoney));
                    }
                    break;
                }
            }
        });
    }



    //Menu_
    public void handleClick(ActionEvent e) {

        if (e.getSource() == Home) {
            Home_1.setVisible(true);
            Order_tab.setVisible(false);
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(false);
        }
        if (e.getSource() == Order_button) {
            Home_1.setVisible(false);
            if(orderVisible==false) {
                Order_tab.setVisible(true);
                Order_tab_2.setVisible(false);
            } else {
                Order_tab.setVisible(true);
                Order_tab_2.setVisible(true);
            }
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(false);

            //content of orderTab
//            Order_tab_2.setVisible(false);

        }
        if (e.getSource() == Buy_product) {
            Home_1.setVisible(false);
            Order_tab.setVisible(false);
            Buy_product_1.setVisible(true);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(false);
        }
            if (e.getSource() == product) {
                Home_1.setVisible(false);
                Order_tab.setVisible(false);
                Buy_product_1.setVisible(false);
                product_1.setVisible(true);
                credit_1.setVisible(false);
                employees_1.setVisible(false);
            }

            if (e.getSource() == employees) {
                Home_1.setVisible(false);
                Order_tab.setVisible(false);
                Buy_product_1.setVisible(false);
                product_1.setVisible(false);
                credit_1.setVisible(false);
                employees_1.setVisible(true);
            }
        if (e.getSource() ==credit) {
            Home_1.setVisible(false);
            Order_tab.setVisible(false);
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(true);
            employees_1.setVisible(false);
        }
        }

        //Login_tab
    public void Login_event() {
        Close_Click(Login_tab, Close_Button);
        Login_Forget(Login2, Login_tab);
        Login_Forget(Login, Login_tab);
    }

        //Order_tab
    public void Order_event() {
        //mo_tab_tao_don_hang
        createOrder();
        //tab_thanh_toan
        Open_Click(Payment_tab, Paid_button_Order);
        Close_Click(Payment_tab,Cancel_Paid_btn );
        ToTal_text_Order.setText("gnctt");
        ToTal_text_Order.setEditable(false);
        ExCash_text_Order.setEditable(false);

        get_Text(id_product_Order, number_Order, Add_btn_Order);
        //endm
    }

    public void createOrder(){
        if(orderVisible==false)
            Open_Click(Order_tab_2, Order_click);
    }

    public ArrayList<String> listProductId(){
        ArrayList<String> listId= new ArrayList<String>();
        for (int i=0;i<productsList.size();i++){
            String result = new String();
            result=productsList.get(i).getIdProduct()+"("+productsList.get(i).getNameProduct()+")";
            listId.add(result);
        }
        return listId;
    }

    public void select_product() {
        product_table.setOnMouseClicked(event -> {
            product_table.setEditable(true);
            src.product s = product_table.getSelectionModel().getSelectedItem();
            currentProductIdChoice=s.getIdProduct();
            detail_pro.setVisible(true);
        });

    }

    public void detail_table(ActionEvent e) {
        setShipmentList();
        detail_table.setVisible(true);
        Close_detail.setVisible(true);
    }

    public void Closee(ActionEvent e) {
        detail_table.setVisible(false);
        Close_detail.setVisible(false);
        detail_pro.setVisible(false);
    }

    //product_event
    // su kien Add de them san pham
    public void add (ActionEvent e){
//        product newproduct = new product();
//        newproduct.setIdProduct(maid_pro.getText());
//        newproduct.setNameProduct(tenid_pro.getText());
//        newproduct.setAmountOfProduct(Integer.parseInt(soluongid_pro.getText()));
//        newproduct.setPrice(Integer.parseInt(giaid_pro.getText()));
//        newproduct.setStateOfProduct(tinhtrangid_pro.getText());
//        productsList.add(newproduct);
    }
    // su kien delete de xoa san pham

    public void delete(ActionEvent e){
        //  productsList.remove(products.getSelectionModel().getSelectedItem());
        product selected = product_table.getSelectionModel().getSelectedItem();
        productsList.remove(selected);
    }
    //create-Order
    public void create_order() {
        STT_Order.setCellValueFactory(new PropertyValueFactory<order, Integer>("STT_Order"));
        ID_Order.setCellValueFactory(new PropertyValueFactory<order, String>("idProduct"));
        Name_Order.setCellValueFactory(new PropertyValueFactory<order, String>("nameProduct"));
        Price_Order.setCellValueFactory(new PropertyValueFactory<order, Integer>("price"));
        Amount_Order.setCellValueFactory(new PropertyValueFactory<order, Integer>("amountOfOrder"));
        Sum_Order.setCellValueFactory(new PropertyValueFactory<order, Integer>("totalOrderCost"));
        OrDer_table.setItems(ordersList);
    }

    public void add_Order (ActionEvent e){
//        order neworder = new order();
//        neworder.setIdProduct(id_product_Order.getText());
//        neworder.setNameProduct("bim bim"); // phu thuoc vao id
//        neworder.setAmountOfOrder(Integer.parseInt(number_Order.getText()));
//        neworder.setPrice(100); // phu thuoc vao id
//        neworder.setStateOfOrder("con"); // lay trong tung ban ghi phu thuoc vao id product
//        neworder.setSTT_Order(3); // set_stt
//        neworder.setTotalOrder(Integer.parseInt(number_Order.getText()) * 100);
//        ordersList.add(neworder);
    }

    public void delete_Order(ActionEvent e){
        //  productsList.remove(products.getSelectionModel().getSelectedItem());
        order selected = OrDer_table.getSelectionModel().getSelectedItem();
        ordersList.remove(selected);
        Double totalMoney =0.0;
        for(int j=0 ; j<ordersList.size();j++){
            totalMoney=totalMoney+ordersList.get(j).getTotalOrderCost();
        }
        Total_money_Order.setText(Double.toString(totalMoney));
    }

    public void handleChangeNameProduct(TableColumn.CellEditEvent edittedCell){
        product productSelect = product_table.getSelectionModel().getSelectedItem();
        productSelect.setNameProduct(edittedCell.getNewValue().toString());
        ConnectionUtils.updateDataProducts(productSelect);
        setProductlist();
    }
    public void handleChangePriceProduct(TableColumn.CellEditEvent edittedCell){
        product productSelect = product_table.getSelectionModel().getSelectedItem();
        double price = Double.parseDouble(edittedCell.getNewValue().toString());
        productSelect.setPrice(price);
        ConnectionUtils.updateDataProducts(productSelect);
        setProductlist();
    }
    public void handleChangeQuantityShipment(TableColumn.CellEditEvent edittedCell){
        shipment shipmentSelect = detail_table.getSelectionModel().getSelectedItem();
        int Quantity= Integer.parseInt(edittedCell.getNewValue().toString());
        shipmentSelect.setAmountOfProduct(Quantity);
        ConnectionUtils.updateDataShipments(shipmentSelect);
        setShipmentList();
        setProductlist();
    }



    }







