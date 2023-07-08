package by.sterlikov.homework25goods.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class UserListProduct {
    private int id;
    private String name;
    private List<Product> products;

    public UserListProduct(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
    public UserListProduct(int id,List<Product> products){
        this.id = id;
        this.products = products;
    }
}
