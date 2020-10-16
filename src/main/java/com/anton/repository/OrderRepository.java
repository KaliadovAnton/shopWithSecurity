package com.anton.repository;

import com.anton.model.Order;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private static final String SQL_SELECT_BY_USER_ID = "SELECT*FROM orders WHERE userID=?";
    public static final String SQL_INSERT_ORDER = "INSERT INTO orders(userID,total_price) VALUES(?,?)";

   // public void saveOrder(Order order) {
   //     try (Connection connection = DBConnector.getConnection();
   //          PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {
   //         preparedStatement.setInt(1, order.getUserID());
   //         preparedStatement.setDouble(2, order.getSum());
  //          order.setId(preparedStatement.executeUpdate());

  //      } catch (SQLException e) {
  //          throw new RuntimeException();
  //      }

  //  }

   // public List<Order> getListOrderByUser(int userID) {
    //    List<Order> orders= new ArrayList<>();
    //    try(Connection connection= DBConnector.getConnection();
    //        PreparedStatement preparedStatement= connection.prepareStatement(SQL_SELECT_BY_USER_ID)){
    //        preparedStatement.setInt(1, userID);
   //         ResultSet resultSet= preparedStatement.executeQuery();
   //         orders = getOrders(resultSet);
   //     } catch (SQLException e) {
   //         e.printStackTrace();
   //     }
   //     return orders;
   // }

 //   private Order getOrder(ResultSet resultSet) throws SQLException {
   //     while (resultSet.next()) {
     //       return new Order(
       //             resultSet.getInt("id"),
         //           resultSet.getInt("userID"),
           //         resultSet.getDouble("total_price"));
       // }
       // return null;
   // }

    //private List<Order> getOrders(ResultSet resultSet) throws SQLException {
      //  List<Order> orders=new ArrayList<>();
        //while (resultSet.next()) {
          //  orders.add(new Order(
            //        resultSet.getInt("id"),
              //      resultSet.getInt("userID"),
                //    resultSet.getDouble("total_price")));
        //}
        //return  orders;
    //}

}
