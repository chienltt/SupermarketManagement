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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    @FXML
    private JFXTextField input_sp1;

    @FXML
    private JFXButton Login2;

    @FXML
    private JFXButton Select;

    @FXML
    private JFXButton Home_1;

    @FXML
    private JFXListView<String> suggest1;

    @FXML
    private VBox Menu1;

    @FXML
    private JFXButton Select1;

    @FXML
    private JFXButton Home2;
    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton Login;

    public Boolean check_select = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //ss;
        input_sp1.setOnKeyReleased(event -> {
            String NewWord = input_sp1.getText();
            System.out.println("this is " + NewWord);
            suggest1.getItems().clear();
            String [] chuoi = new String[3];
            chuoi[0] = "gnctt";
            chuoi[1] = "no";
            chuoi[2] = "like";
            suggest1.getItems().addAll(chuoi);
            suggest1.setVisible(true);
        });

        suggest1.setOnMouseClicked(event -> {
            String searchedWord = suggest1.getSelectionModel().getSelectedItem();
            if (searchedWord != null && searchedWord.equals("") == false) {
                System.out.println("Searched World: " + searchedWord);
                input_sp1.setText(searchedWord);
                suggest1.setVisible(false);
            }
        });

        //ss;
    }

    public void changeScene(ActionEvent event) throws IOException {
        String us = username.getText();
        String ps = password.getText();
        System.out.println(us + " " + ps);
        if (us.equals("gnctt") && ps.equals("gnctt")) {
            Parent root2 = FXMLLoader.load(getClass().getResource("dgn1.fxml"));
            Scene scene = new Scene(root2);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        }
    }

    public void changeScene2(ActionEvent event) throws IOException {
            Parent root2 = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root2);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        }
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
    }
