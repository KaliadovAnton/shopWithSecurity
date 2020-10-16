package com.anton.repository;

import com.anton.model.Good;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GoodRepository {

    private static final String SQL_SELECT_ALL_PRODUCTS = "SELECT*FROM products";
    private static final String SQL_SELECT_BY_NAME="SELECT*FROM products WHERE name=?";

    //public List<Good> getGoods() {
       // List<Good> products = new ArrayList<>();
       // try (Connection connection = DBConnector.getConnection()) {
         //   try (Statement statement = connection.createStatement()) {
        //        ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_PRODUCTS);
        //        products = getProducts(resultSet);
         //   }
      //  } catch (SQLException e) {
       //     e.printStackTrace();
      //  }
     //   return products;
//    }


  //  public Good getGoodByName(String productName) {
    //    Good product=null;
    //    try(Connection connection = DBConnector.getConnection()) {
     //       try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_NAME)) {
      //          preparedStatement.setString(1, productName);
     //           final ResultSet resultSet = preparedStatement.executeQuery();
      //          product = getProduct(resultSet);
    //        }
   //     } catch (SQLException e) {
    //        e.printStackTrace();
   //     }
  //      return product;
 //   }

   // private Good getProduct(ResultSet resultSet) throws SQLException {
      //  while (resultSet.next()) {
       //     return new Good(
       //             resultSet.getString("name"),
       //             resultSet.getDouble("price"),
       //             resultSet.getInt("id"));
      //  }
       // return null;
  //  }

   // private List<Good> getProducts(ResultSet resultSet) throws SQLException {
   //     List<Good> products = new ArrayList<>();
   //     while (resultSet.next()) {
   //         products.add( new Good(resultSet.getString("name"),
    //                resultSet.getDouble("price"),
    //                resultSet.getInt("id")));
    //    }
    //    return products;
   // }
}
