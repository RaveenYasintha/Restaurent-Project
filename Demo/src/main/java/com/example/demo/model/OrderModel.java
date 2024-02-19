package com.example.demo.model;

import com.example.demo.TO.Item;

import java.sql.*;
import java.util.ArrayList;

public class OrderModel {
    public static Item getItem(String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/choppe",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from fooditem where food_name=?");
            stm.setObject(1,id);

            ResultSet rst = stm.executeQuery();

            Item item = new Item();


            while (rst.next()) {
                item.setF_id(rst.getInt(1));
                item.setF_name(rst.getString(2));
                item.setPrice(rst.getDouble(3));
                item.setF_quantity(rst.getInt(4));
            }
            return item;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> loadItemIds () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/choppe",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select food_name from fooditem");


            ResultSet rst = stm.executeQuery();

            ArrayList<String> ids = new ArrayList<>();

            while (rst.next()) {
                ids.add(rst.getString(1));
            }
            return ids;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
