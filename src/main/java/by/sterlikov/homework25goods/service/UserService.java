package by.sterlikov.homework25goods.service;

import by.sterlikov.homework25goods.model.Product;
import by.sterlikov.homework25goods.model.User;
import by.sterlikov.homework25goods.model.UserListProduct;

import java.util.Map;

public interface UserService {
    public void addUser(User user) throws ClassNotFoundException;

    public void addListProduct(UserListProduct user) throws ClassNotFoundException;

    public Map<User, Product> findAllListProduct();

    public User findUsers(String login) throws ClassNotFoundException;
}
