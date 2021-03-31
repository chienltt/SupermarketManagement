package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import src.ControllerData;
import src.date;
import src.product;
import src.shipment;

public class Controller implements Initializable {

    //Login_var
    private Boolean Logined = false;

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
    private JFXButton Sell_product;

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
    private AnchorPane Sell_product_1;

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
    private TableColumn<product, Integer> macol;
    @FXML
    private TableColumn<product, String> tencol;
    @FXML
    private TableColumn<product, Integer> soluongcol;
    @FXML
    private TableColumn<product, String> giacol;
//    @FXML
//    private TableColumn<product, String> ngaynhapcol;
//    @FXML
//    private TableColumn<product, String> HSDcol;
    @FXML
    private TableColumn<product, String> tinhtrangcol;
//    @FXML
//    private TableColumn<product, String> xulicol;

//    private TableColumn<product, String> malohangcol;

    private ObservableList<product> productList;



    // Signal_var
    public Boolean check_select = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //ss;

        this.Close_Click(Login_tab, Close_Button);
        this.Login_Forget(Login2, Login_tab);
        this.Login_Forget(Login, Login_tab);

//        shipment shipment1=new shipment("198238912y84218",10,new date(12,10,2020),new date(2020,10,12));
//        shipment shipment2=new shipment("198238912y84218",10,new date(12,10,2020),new date(2020,10,12));
//        ArrayList<shipment> listProducts=new ArrayList<shipment>();
//        listProducts.add(shipment1);
//        listProducts.add(shipment2);

        macol.setCellValueFactory(new PropertyValueFactory<product, Integer>("ma san pham"));
//        malohangcol.setCellValueFactory(new PropertyValueFactory<product,String>("ma lo hang"));
        tencol.setCellValueFactory(new PropertyValueFactory<product, String>("ten san pham "));
        soluongcol.setCellValueFactory(new PropertyValueFactory<product, Integer>("so luong"));
        giacol.setCellValueFactory(new PropertyValueFactory<product, String>("gia"));
//        ngaynhapcol.setCellValueFactory(new PropertyValueFactory<product, String>("ngaynhap"));
//        HSDcol.setCellValueFactory(new PropertyValueFactory<product, String>("HSD"));
        tinhtrangcol.setCellValueFactory(new PropertyValueFactory<product, String>("tinhtrang"));
//        xulicol.setCellValueFactory(new PropertyValueFactory<product, String>("xuli"));
        product_table.setItems(setProductlist());
        //ss;
    }

    public ObservableList<product> setProductlist(){
        ObservableList<product> productlist= FXCollections.observableArrayList();
        for (int i=0;i< ControllerData.listProducts.size();i++){
            productlist.add(ControllerData.listProducts.get(i));
        }
        productlist.add(new product("mi tom","aoiwdiuajwd",4.00));
        System.out.println(productlist);
        return productlist;
    }

    public void Close_Click(AnchorPane tab, JFXButton but) {
        but.setOnMouseClicked(event -> {
            tab.setVisible(false);
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



    //Menu_
    public void handleClick(ActionEvent e) {

        if (e.getSource() == Home) {
            LB_Name.setText("trang chủ");
            Home_1.setVisible(true);
            Sell_product_1.setVisible(false);
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(false);
        }
        if (e.getSource() == Sell_product) {
            LB_Name.setText("tạo đơn hàng");
            Home_1.setVisible(false);
            Sell_product_1.setVisible(true);
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(false);
        }
        if (e.getSource() == Buy_product) {
            LB_Name.setText("nhập lô hàng");
            Home_1.setVisible(false);
            Sell_product_1.setVisible(false);
            Buy_product_1.setVisible(true);
            product_1.setVisible(false);
            credit_1.setVisible(false);
            employees_1.setVisible(false);
        }
            if (e.getSource() == product) {
                LB_Name.setText("sản phẩm");
                Home_1.setVisible(false);
                Sell_product_1.setVisible(false);
                Buy_product_1.setVisible(false);
                product_1.setVisible(true);
                credit_1.setVisible(false);
                employees_1.setVisible(false);
            }

            if (e.getSource() == employees) {
                LB_Name.setText("nhân viên");
                Home_1.setVisible(false);
                Sell_product_1.setVisible(false);
                Buy_product_1.setVisible(false);
                product_1.setVisible(false);
                credit_1.setVisible(false);
                employees_1.setVisible(true);
            }
        if (e.getSource() ==credit) {
            LB_Name.setText("thẻ tín dụng");
            Home_1.setVisible(false);
            Sell_product_1.setVisible(false);
            Buy_product_1.setVisible(false);
            product_1.setVisible(false);
            credit_1.setVisible(true);
            employees_1.setVisible(false);
        }
        }
    }



