package by.sterlikov.homework25goods.service;

import by.sterlikov.homework25goods.model.Product;
import by.sterlikov.homework25goods.model.User;
import by.sterlikov.homework25goods.model.UserListProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

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

    Boolean existUser;

    @Override
    public void addUserListProduct(UserListProduct user) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String queryInsertProduct = "INSERT INTO Products (id_user, id_product, name_product, id_category) VALUES (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_homework25Goods"
                , "root", "root")) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryInsertProduct);
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
        String queryInsertProduct = "INSERT INTO Products ( id_product, name_product, id_category) VALUES (?,?,?,?)";
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
    public List<User> findUsers() throws ClassNotFoundException {
        return null;
    }

    @Override
    public Boolean findUsers(String login) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String query = "SELECT * FROM Users";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_homework25Goods"
                , "root", "root")) {
            List<User> users = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id;
                String name;
                id = resultSet.getInt("id_user");
                name = resultSet.getString("name_user");
                User user = new User(id, name);
                users.add(user);
                for (User i : users) {
                    if (i.getName().equalsIgnoreCase(login)) {
                        existUser = true;
                    }
                    existUser = false;
                }
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
