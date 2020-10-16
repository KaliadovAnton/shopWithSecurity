package com.anton.repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class OrderGoodRepository {

    public static final String SQL_INSERT_ORDER_GOOD = "INSERT INTO order_good(orderID,productID) VALUES(?,?)";

   // public void save(int orderID, int productID) {
     //   try(Connection connection= DBConnector.getConnection()){
     //       try(PreparedStatement preparedStatement=connection.prepareStatement(SQL_INSERT_ORDER_GOOD)){
     //           preparedStatement.setString(1, Integer.toString(orderID));
    //            preparedStatement.setString(2, Integer.toString(productID));
    //            preparedStatement.executeUpdate();
    //        }
   //     } catch (SQLException e) {
   //         e.printStackTrace();
   //     }
  //  }
}
