package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


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

// else


    @FXML
    private JFXButton Home_1;


    @FXML
    private VBox Menu1;

    @FXML
    private JFXButton Select1;

    @FXML
    private JFXButton Home2;




    public Boolean check_select = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //ss;

        this.Close_Click(Login_tab, Close_Button);
        this.Login_Forget(Login2, Login_tab);
        this.Login_Forget(Login, Login_tab);




        //ss;
    }

    public void Close_Click(AnchorPane tab, JFXButton but){
        but.setOnMouseClicked(event -> {
            tab.setVisible(false);
        });
    }
    // Tab_dang_nhap
    public void Login_Forget(JFXButton login, AnchorPane Login_tab){
        login.setOnMouseClicked(event -> {
            System.out.println(Login_tab.isVisible());
            if (!Login_tab.isVisible()){
                Login_tab.setVisible(true);
            }
            else {
                String user = username.getText();
                String pass = password.getText();
                //check_ki_tu_khi_dang_nh
                // xu_li_thong_tin_dang_nhap
                if (Check_key(user, pass, 4, 16) && (user.equals("gnctt") && pass.equals("191001")) ) {

                    Login_tab.setVisible(false);
                    username.setText("");
                    password.setText("");
                    notify_login.setText("");
                    Logined = true;
                    if(Logined) {
                        Login2.setText("Đăng xuất");
                    }
                    else{
                        Login2.setText("Đănh nhập");
                    }
                }
                else {
                    if(!Check_key(user, pass, 4, 16)){
                        notify_login.setText("* tài khoản mật khẩu không đúng định dạng, không \n" +
                                "chứa kí tự đặc biệt, dài hơn 4 kí tự không quá 16 kí tự");
                    }
                    else{
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
            }
            else {
                content.setText("          tài khoản chưa tồn tại\n" +
                        "            hãy đăng kí với quản lí");
            }
        });
    }
    //


    public void ButtonSelect(ActionEvent event) {
        if (check_select) {
            Menu1.setVisible(true);
            check_select = false;
        }
        else {
            Menu1.setVisible(false);
            check_select = true;
        }

    }



    // Kiem_tra_dinh_dang_us_ps;

    public boolean Check_space(String a){
        for (int i = 0; i < a.length(); i++) {
            if ((a.charAt(i) >= 65 && a.charAt(i) <= 90) || (a.charAt(i) >= 97 && a.charAt(i) <= 122) || (a.charAt(i) >= 48 && a.charAt(i) <= 57) ) {

                return true;
            }
        }
        return false;
    }

    public boolean Check_key(String a, String b,int minlength, int maxlength) {
        if (a.length() <= minlength || b.length() <= minlength || a.length() >= maxlength || b.length() >= maxlength) {
            return false;
        }
        else {
            if(Check_space(a) && Check_space(b)) {
                return true;
            }
        }
        return false;
    }
    }
