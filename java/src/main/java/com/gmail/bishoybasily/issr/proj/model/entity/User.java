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

    public static User from(Long id, String name, String email, String telephone) {
        return new User()
                .setId(id)
                .setName(name)
                .setEmail(email)
                .setTelephone(telephone);
    }

    public static User from(String name, String email, String telephone) {
        return new User()
                .setName(name)
                .setEmail(email)
                .setTelephone(telephone);
    }

}
