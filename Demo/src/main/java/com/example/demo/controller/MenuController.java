package com.example.demo.controller;

import com.example.demo.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    public AnchorPane root;

    @FXML
    void btnBack(ActionEvent event) {

        try {


            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/login-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            stage.setScene(scene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnClose(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnItems(ActionEvent event) {

        try {


            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/item-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            stage.setScene(scene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnOrder(ActionEvent event) {

        try {


            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/order-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            stage.setScene(scene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnOrderDetails(ActionEvent event) {

        try {


            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/orderDetail-view.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            stage.setScene(scene);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
