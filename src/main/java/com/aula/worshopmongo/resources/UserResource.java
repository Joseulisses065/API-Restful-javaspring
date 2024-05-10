package com.aula.worshopmongo.resources;

import com.aula.worshopmongo.domain.User;
import com.aula.worshopmongo.dto.UserDto;
import com.aula.worshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<User> list = service.findAll();
        List<UserDto> dtoList = list.stream().map(x->new UserDto(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }
}
