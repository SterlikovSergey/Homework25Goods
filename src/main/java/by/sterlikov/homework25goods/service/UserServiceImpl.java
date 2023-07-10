package by.sterlikov.homework25goods.service;

import by.sterlikov.homework25goods.model.Product;
import by.sterlikov.homework25goods.model.User;
import by.sterlikov.homework25goods.model.UserListProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    User existUser;

    @Override
    public void addUser(User user) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_homework25Goods"
                , "root", "root")) {
            String queryInsertUser = "INSERT INTO Users(name_user) VALUE (?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(queryInsertUser);
            preparedStatement1.setString(1, user.getName());
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addListProduct(UserListProduct user) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String queryInsertProduct = "INSERT INTO Products ( id_user, id_product, name_product, id_category) VALUES (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_homework25Goods"
                , "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryInsertProduct);
            preparedStatement.setInt(1, user.getId());
            for (Product products : user.getProducts()) {
                preparedStatement.setInt(2, products.getId());
                preparedStatement.setString(3, products.getName());
                preparedStatement.setInt(4, products.getCategory());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUsers(String login) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "SELECT * FROM Users WHERE name_user = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_homework25Goods"
                , "root", "root")) {
            List<User> users = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id;
                String name;
                id = resultSet.getInt("id_user");
                name = resultSet.getString("name_user");
                existUser = new User(id, name);
            }
            return existUser;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<User, Product> findAllListProduct() {
        return null;
    }
}
