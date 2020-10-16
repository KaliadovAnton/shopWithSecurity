package com.anton.repository;

import com.anton.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private static final String SQL_SELECT_BY_LOGIN = "SELECT*FROM users WHERE  login=?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT*FROM users";
    private static final String SQL_INSERT_USER = "INSERT INTO users(login,password) VALUES(?,?)";

   // public Optional<User> getUserByLogin(String login) {
    //    User user=null;
   //     try(Connection connection = DBConnector.getConnection()) {
   //         try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BY_LOGIN)) {
    //            preparedStatement.setString(1, login);
    //            final ResultSet resultSet = preparedStatement.executeQuery();
    //            user = getUser(resultSet);
   //         }
   //     } catch (SQLException e) {
    //        e.printStackTrace();
   //     }
   //     return Optional.ofNullable(user);
  //  }

   // public List<User> getAll() {
   //     try(Connection connection = DBConnector.getConnection()) {
   //         try(Statement statement = connection.createStatement()){
   //             ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
   //             return getUsers(resultSet);
  //          }
   //     } catch (SQLException e) {
   //         e.printStackTrace();
   //     }
   //     return  null;
  //  }

  //  public void save(User user) {
    //    try(Connection connection=DBConnector.getConnection()){
    //        try(PreparedStatement preparedStatement=connection.prepareStatement(SQL_INSERT_USER)){
    //            preparedStatement.setString(1, user.getName());
    //            preparedStatement.setString(2, user.getPassword());
    //            preparedStatement.executeUpdate();
    //        }
    //    } catch (SQLException e) {
    //        e.printStackTrace();
    //    }
   // }

    private List<User> getUsers(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>() ;
        while (resultSet.next()) {
            String userLogin = resultSet.getString("login");
            String password = resultSet.getString("password ");
            users.add(new User(userLogin, password));
        }
        return users;
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            return new User(resultSet.getString("login"),resultSet.getString("password"));
        }
        return null;
    }
}
