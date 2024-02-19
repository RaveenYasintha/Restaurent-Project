package com.example.demo.controller;

import com.example.demo.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderDetailController {

    public AnchorPane root;
    @FXML
    private TableView<?> tblOrderDetail;

    @FXML
    void btnBack(ActionEvent event) {

        try {


            Stage stage = (Stage) this.root.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/menu-view.fxml"));

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

}
