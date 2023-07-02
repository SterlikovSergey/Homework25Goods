package by.sterlikov.homework25goods.service;

import by.sterlikov.homework25goods.model.Product;
import by.sterlikov.homework25goods.model.User;
import by.sterlikov.homework25goods.model.UserListProduct;

import java.sql.SQLException;

public interface UserService {
    public void addProduct(User user, Product product) throws ClassNotFoundException, SQLException;
    public void addUserListProduct(UserListProduct user) throws ClassNotFoundException;

}
