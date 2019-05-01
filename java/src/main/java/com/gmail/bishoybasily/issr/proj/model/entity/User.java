package com.gmail.bishoybasily.issr.proj.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {

    private Long id;
    private String name;
    private String email;
    private String telephone;

    public User(Long id, String name, String email, String telephone) {
        this(name, email, telephone);
        this.id = id;
    }

    public User(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

}
