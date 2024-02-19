package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.TO.Item;
import com.example.demo.TM.OrderTM;
import com.example.demo.model.OrderModel;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderController implements Initializable {

    public AnchorPane root;

    @FXML
    private ComboBox<String> comboItemName;

    @FXML
    private TextField txtOrderID;

    @FXML
    private TextField txtQuantity;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblDescription;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblCurruntTotal;

    @FXML
    private TableView<OrderTM> tblOrder;

    @FXML
    void btnAddToCart(ActionEvent event) {

        double total = Double.parseDouble(lblPrice.getText()) * Integer.parseInt(txtQuantity.getText());
        tblOrder.getItems().add(new OrderTM(Integer.parseInt(txtOrderID.getText()),comboItemName.getSelectionModel().getSelectedItem(),Double.parseDouble(lblPrice.getText()),Integer.parseInt(txtQuantity.getText()),total));

        double currentTotal = Double.parseDouble(lblCurruntTotal.getText())+total;
        lblCurruntTotal.setText(String.valueOf(currentTotal));

    }

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

    @FXML
    void btnConfirm(ActionEvent event) {

    }

    @FXML
    void btnPrint(ActionEvent event) {

    }


    @FXML
    void selectItem(ActionEvent event){
        Item item = OrderModel.getItem(comboItemName.getSelectionModel().getSelectedItem());
        txtQuantity.setText(String.valueOf(item.getF_quantity()));
        lblDescription.setText(item.getF_name());
        lblPrice.setText(String.valueOf(item.getPrice()));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<String> strings = OrderModel.loadItemIds();
        comboItemName.setItems(FXCollections.observableArrayList(strings));

        tblOrder.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ordId"));
        tblOrder.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("foodName"));
        tblOrder.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("uniPrice"));
        tblOrder.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("quanti"));
        tblOrder.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>( "tot"));
    }
}
