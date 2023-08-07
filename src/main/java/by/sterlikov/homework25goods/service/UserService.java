package by.sterlikov.homework25goods.service;

import by.sterlikov.homework25goods.model.Product;
import by.sterlikov.homework25goods.model.User;
import by.sterlikov.homework25goods.model.UserListProduct;

import java.util.Map;

public interface UserService {
    public void addUser(User user) throws ClassNotFoundException;

    public void addUserListProduct(UserListProduct user) throws ClassNotFoundException;

    public Map<User, Product> findAllListProduct();

    public User findUserByLogin(String login) throws ClassNotFoundException;
}
