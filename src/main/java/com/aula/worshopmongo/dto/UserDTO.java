package com.aula.worshopmongo.dto;

import com.aula.worshopmongo.domain.User;

public class UserDTO {
    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.email = obj.getEmail();
        this.name = obj.getName();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
