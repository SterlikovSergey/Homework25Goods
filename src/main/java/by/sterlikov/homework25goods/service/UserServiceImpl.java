package by.sterlikov.homework25goods.service;

import by.sterlikov.homework25goods.model.Product;
import by.sterlikov.homework25goods.model.User;
import by.sterlikov.homework25goods.model.UserListProduct;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    User existUser;

    @Override
    public void addProduct(User user, Product product) throws ClassNotFoundException, SQLException {
        /*Class.forName("com.mysql.cj.jdbc.Driver");
        String queryInsertProduct = "INSERT INTO PRODUCTS (id_product, name_product, category) VALUES (?,?,?)";
        String queryInsertUser = "INSERT iNTO USERS (name) VALUES (?)";
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_homework25Goods"
                ,"root","root")){
            PreparedStatement preparedStatement = connection.prepareStatement(queryInsertProduct);
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setInt(3,product.getCategory());
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement1 = connection.prepareStatement(queryInsertUser);
            preparedStatement1.setString(1, user.getName());
            preparedStatement1.executeUpdate();*/
    }

    @Override
    public void addUserListProduct(UserListProduct user) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String queryInsert = "INSERT INTO Products (id_user, id_product, name_product, id_category) VALUES (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_homework25Goods"
                , "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryInsert);
            preparedStatement.setInt(1, user.getId());
            for (Product products : user.getProducts()) {
                preparedStatement.setInt(2, products.getId());
                preparedStatement.setString(3, products.getName());
                preparedStatement.setInt(4, products.getCategory());
            }
            String queryInsertUser = "INSERT INTO Users(id_user, name_user) VALUE (?,?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(queryInsertUser);
            preparedStatement1.setInt(1, user.getId());
            preparedStatement1.setString(2, user.getName());
            preparedStatement.executeUpdate();
            preparedStatement1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void addListProduct(UserListProduct user) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String queryInsertProduct = "INSERT INTO Products ( id_user,id_product, name_product, id_category) VALUES (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_homework25Goods"
                , "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryInsertProduct);
            preparedStatement.setInt(1, user.getId());
            for (Product products : user.getProducts()) {
                preparedStatement.setInt(2, products.getId());
                preparedStatement.setString(3, products.getName());
                preparedStatement.setInt(4, products.getCategory());
            }
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
