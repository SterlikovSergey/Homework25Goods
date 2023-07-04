package by.sterlikov.homework25goods.service;

import by.sterlikov.homework25goods.model.Product;
import by.sterlikov.homework25goods.model.User;
import by.sterlikov.homework25goods.model.UserListProduct;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    public void addProduct(User user, Product product) throws ClassNotFoundException, SQLException;
    public void addUserListProduct(UserListProduct user) throws ClassNotFoundException;
    public void addListProduct(UserListProduct user) throws ClassNotFoundException;

    public List<User> findUsers() throws ClassNotFoundException;

    public Map<User,Product> findAllListProduct();
    public Boolean findUsers(String login) throws ClassNotFoundException;

            ;

}
