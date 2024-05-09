package com.aula.worshopmongo.resources;

import com.aula.worshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "maria", "maria@gmail.com");
        User alex = new User("2", "alex", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(alex, maria));
        return ResponseEntity.ok().body(list);
    }
}
