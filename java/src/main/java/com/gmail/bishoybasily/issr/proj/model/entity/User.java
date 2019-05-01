package com.gmail.bishoybasily.issr.proj.model.entity;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    private SimpleLongProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty email;
    private SimpleStringProperty telephone;

    public static User from(Long id, String name, String email, String telephone) {
        return new User()
                .setId(new SimpleLongProperty(id))
                .setName(new SimpleStringProperty(name))
                .setEmail(new SimpleStringProperty(email))
                .setTelephone(new SimpleStringProperty(telephone));
    }

    public static User from(String name, String email, String telephone) {
        return new User()
                .setName(new SimpleStringProperty(name))
                .setEmail(new SimpleStringProperty(email))
                .setTelephone(new SimpleStringProperty(telephone));
    }

}
