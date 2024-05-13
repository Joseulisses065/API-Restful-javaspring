package com.aula.worshopmongo.dto;

import com.aula.worshopmongo.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private String id;
    private String name;

    public AuthorDTO(User user) {
        id = user.getId();
        name= user.getName();
    }

    public AuthorDTO() {
    }


}
