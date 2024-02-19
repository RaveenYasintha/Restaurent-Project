package com.example.demo.controller;

import com.example.demo.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LogingController {



    public AnchorPane root;
    @FXML
    private ImageView imgBackground;

    @FXML
    private TextField txtUserName;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Text lblLoging;

    @FXML
    void btnClose(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnLogin(ActionEvent event){
        System.out.println("ok");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/choppe", "root", "1234");

            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM user WHERE user_name=?  AND password=?;");
            pstm.setObject(1,txtUserName.getText());
            pstm.setObject(2,txtPassword.getText());

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()) {

                System.out.println("Connection");
                try {


                    Stage stage = (Stage) this.root.getScene().getWindow();

                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view.fxml"));

                    Scene scene = new Scene(fxmlLoader.load());

                    stage.setScene(scene);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else {
                new Alert(Alert.AlertType.ERROR).show();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }





    }
}
