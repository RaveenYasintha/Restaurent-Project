package com.example.demo.db;

public class DBConnection {
    private static DBConnection dbConnection;

    //cannot create objects in outer classes

    private DBConnection(){

    }

    public static DBConnection getInstance(){
        if (dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }
}
