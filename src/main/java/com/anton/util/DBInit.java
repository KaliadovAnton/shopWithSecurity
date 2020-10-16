package com.anton.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DBInit {

    private static final String SQL = "CREATE  TABLE products (" +
            "id int AUTO_INCREMENT," +
            "name varchar," +
            "price double," +
            "PRIMARY KEY (id)" +
            ");"+

            "INSERT INTO products(id,name,price) VALUES(1,'Milk',2);"+
            "INSERT INTO products(id,name,price) VALUES(2,'Bread',1.5);"+
            "INSERT INTO products(id,name,price) VALUES(3,'Beef',4.0);"+

            "CREATE TABLE  users("+
            "id int AUTO_INCREMENT NOT NULL UNIQUE,"+
            "login VARCHAR NOT NULL UNIQUE,"+
            "password varchar, "+
            "PRIMARY KEY (id)" +
            ");"+

            "CREATE TABLE  orders("+
            "id int AUTO_INCREMENT NOT NULL UNIQUE,"+
            "userID int NOT NULL ,"+
            " total_price double NOT NULL,"+
            "PRIMARY KEY (id), " +
            "FOREIGN KEY (userID) REFERENCES users(id)"+
            ");"+

            "CREATE TABLE  order_good("+
            "id int AUTO_INCREMENT NOT NULL UNIQUE,"+
            "orderID int NOT NULL ,"+
            "productID double NOT NULL, "+
            "PRIMARY KEY (id)," +
            "FOREIGN KEY (orderID) REFERENCES orders(id),"+
            "FOREIGN KEY (productID) REFERENCES products(id)"+
            ");";

    static final String destroy=" DROP TABLE PRODUCTS;" +
            "DROP TABLE order_good;" +
            "DROP TABLE orders;" +
            "DROP TABLE users";

   // @PostConstruct
   // public void contextInitialize() {
    //    Connection connection=DBConnector.getConnection();
    //    try {
    //        Statement statement= connection.createStatement();
    //        statement.execute(SQL);
   //     } catch (SQLException e) {
   //         e.printStackTrace();
   //     }
   // }
   // @PreDestroy
   // public void destroy(){
   //     Connection connection=DBConnector.getConnection();
    //    try {
    //        Statement statement= connection.createStatement();
    //        statement.execute(destroy);
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
 //   }
}
