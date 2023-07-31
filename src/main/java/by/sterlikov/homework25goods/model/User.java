package by.sterlikov.homework25goods.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(Integer id) {
        this.id = id;
    }

}
