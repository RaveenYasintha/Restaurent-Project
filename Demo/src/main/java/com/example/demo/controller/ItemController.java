package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.TO.Item;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemController implements Initializable {

    public AnchorPane root;
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtItemName;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private TextField txtQuantity;


    @FXML
    private TableView<Item> tblFoodItem;

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void btnSearch(ActionEvent event) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/choppe",
                    "root","1234");

            PreparedStatement stm = connection.prepareStatement("select * from fooditem where  item_id= ?");

            stm.setObject(1,txtId.getText());


            ResultSet rst= stm.executeQuery();

            while(rst.next()){
                txtItemName.setText(rst.getString(2));
                txtUnitPrice.setText(rst.getString(3));
                txtQuantity.setText(rst.getString(4));

            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void btnDelete(ActionEvent event) {



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/choppe",
                    "root","1234");
        PreparedStatement stm = connection.prepareStatement("DELETE FROM fooditem WHERE item_id=?");

        stm.setObject(1,txtId.getText());

        int i = stm.executeUpdate();

        if(i>0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Food Item Deleted.");
            alert.show();

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Food Item Not Deleted.");
            alert.show();
        }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
    @FXML
    void btnSave(ActionEvent event) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/choppe",
                    "root","1234");

            PreparedStatement stm = connection.prepareStatement("insert into fooditem values (?,?,?,?)");

            stm.setObject(1,txtId.getText());
            stm.setObject(2,txtItemName.getText());
            stm.setObject(3,txtUnitPrice.getText());
            stm.setObject(4,txtQuantity.getText());

            int i = stm.executeUpdate();

            if(i>0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Food Item Saved.");
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Food Item Not Saved.");
                alert.show();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    @FXML
    void btnUpdate(ActionEvent event) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/choppe",
                    "root","1234");

            PreparedStatement stm = connection.prepareStatement("update fooditem set food_name=?,unit_price=?,quantity=? where item_id=?");


            stm.setObject(1,txtItemName.getText());
            stm.setObject(2,txtUnitPrice.getText());
            stm.setObject(3,txtQuantity.getText());
            stm.setObject(4,txtId.getText());



            int rst= stm.executeUpdate();

            if(rst>0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Food Item Updated.");
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Food Item Not Updated.");
                alert.show();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    tblFoodItem.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("f_id"));
    tblFoodItem.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("f_name"));
    tblFoodItem.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
    tblFoodItem.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("f_quantity"));

        ArrayList<Item> fooditems = load();

        tblFoodItem.setItems(FXCollections.observableArrayList(fooditems));


    }
    public ArrayList<Item> load(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/choppe",
                    "root","1234");

            PreparedStatement stm = connection.prepareStatement("select * from fooditem");

            ResultSet rst= stm.executeQuery();

            ArrayList<Item> fooditems = new ArrayList<>();

            while(rst.next()){
                Item fid = new Item(rst.getInt(1), rst.getString(2),rst.getDouble(3),rst.getInt(4));
                fooditems.add(fid);
            }

            return fooditems;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
