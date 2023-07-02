package by.sterlikov.homework25goods.service;

import by.sterlikov.homework25goods.model.Product;
import by.sterlikov.homework25goods.model.User;
import by.sterlikov.homework25goods.model.UserListProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{

    @Override
    public void addProduct(User user,Product product) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
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
            preparedStatement1.executeUpdate();
        }
    }

    @Override
    public void addUserListProduct(UserListProduct user) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String queryInsertProduct = "INSERT INTO PRODUCTS (id_product, name_product, category) VALUES (?,?,?)";
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_homework25Goods"
                ,"root","root")) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryInsertProduct);
            preparedStatement.setInt(1,user.setProducts(););
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
