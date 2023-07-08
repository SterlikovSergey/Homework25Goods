package by.sterlikov.homework25goods.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;

    public User(String name) {
        this.name = name;
    }
    public User(int id){
        this.id = id;
    }

}
