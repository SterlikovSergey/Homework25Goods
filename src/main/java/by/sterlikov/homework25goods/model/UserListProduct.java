package by.sterlikov.homework25goods.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class UserListProduct {
    private String name;
    private List<Product> products;
}
